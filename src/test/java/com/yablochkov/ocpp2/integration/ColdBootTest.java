package com.yablochkov.ocpp2.integration;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import com.yablochkov.ocpp2.adapter.can.CanClient;
import com.yablochkov.ocpp2.adapter.csms.CsmsClient;
import com.yablochkov.ocpp2.adapter.csms.dto.BootNotificationResponse;
import com.yablochkov.ocpp2.adapter.csms.dto.BootNotificationResponse.Status;
import com.yablochkov.ocpp2.adapter.csms.dto.HeartbeatResponse;
import com.yablochkov.ocpp2.adapter.csms.dto.SetVariableData;
import com.yablochkov.ocpp2.adapter.csms.dto.SetVariableData.AttributeEnumType;
import com.yablochkov.ocpp2.adapter.csms.dto.SetVariablesRequest;
import com.yablochkov.ocpp2.adapter.csms.dto.SetVariablesResponse;
import com.yablochkov.ocpp2.adapter.csms.dto.StatusNotificationResponse;
import com.yablochkov.ocpp2.application.service.BootService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

public class ColdBootTest extends AbstractIntegrationTest {

  @MockBean
  CanClient canClient;
  @MockBean
  CsmsClient csmsClient;
  @Autowired
  BootService bootService;

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

  @Test
  public void testColdBootAccepted() throws InterruptedException {
    when(csmsClient.sendBootNotification(any())).thenReturn(new BootNotificationResponse(
        LocalDateTime.now(), 1, Status.ACCEPTED));
    when(csmsClient.sendStatusNotification(any())).thenReturn(new StatusNotificationResponse());
    when(csmsClient.sendHeartbeat(any())).thenReturn(new HeartbeatResponse(LocalDateTime.now()));

    bootService.bootUp();

    TimeUnit.SECONDS.sleep(3);

    var inOrder = inOrder(csmsClient);
    inOrder.verify(csmsClient, times(1)).sendBootNotification(any());
    inOrder.verify(csmsClient, atLeastOnce()).sendStatusNotification(any());
    inOrder.verify(csmsClient, atLeast(2)).sendHeartbeat(any());
  }

  @Test
  public void testColdBootPending() {
    when(csmsClient.sendBootNotification(any()))
        .thenAnswer(invocation -> {
          executorService.schedule(() -> {
            var setVariablesResponse = restTemplate.postForEntity(
                "http://localhost:" + port + "/variable/set",
                new SetVariablesRequest(
                    List.of(new SetVariableData(AttributeEnumType.ACTUAL, "100", 1, "power"),
                        new SetVariableData(AttributeEnumType.TARGET, "10", 1, "current"))),
                SetVariablesResponse.class).getBody();
            assertNotNull(setVariablesResponse);
            assertNotNull(setVariablesResponse.getSetVariableResult());
            assertTrue(Stream.of("power", "current")
                .allMatch(v -> setVariablesResponse.getSetVariableResult().stream()
                    .anyMatch(r -> v.equals(r.getVariable()))));
          }, 100, TimeUnit.MILLISECONDS);
          return new BootNotificationResponse(
              LocalDateTime.now(), 1, Status.PENDING);
        })
        .thenReturn(new BootNotificationResponse(
            LocalDateTime.now(), 1, Status.ACCEPTED));
    when(csmsClient.sendStatusNotification(any())).thenReturn(new StatusNotificationResponse());
    when(csmsClient.sendHeartbeat(any())).thenReturn(new HeartbeatResponse(LocalDateTime.now()));

    bootService.bootUp();

    var inOrder = inOrder(csmsClient);
    inOrder.verify(csmsClient, times(2)).sendBootNotification(any());
    inOrder.verify(csmsClient, atLeastOnce()).sendStatusNotification(any());
    inOrder.verify(csmsClient, atLeastOnce()).sendHeartbeat(any());
  }

  @Test
  public void testColdBootRejected() {
    when(csmsClient.sendBootNotification(any()))
        .thenReturn(new BootNotificationResponse(
            LocalDateTime.now(), 1, Status.REJECTED))
        .thenReturn(new BootNotificationResponse(
            LocalDateTime.now(), 1, Status.ACCEPTED));
    when(csmsClient.sendStatusNotification(any())).thenReturn(new StatusNotificationResponse());
    when(csmsClient.sendHeartbeat(any())).thenReturn(new HeartbeatResponse(LocalDateTime.now()));

    bootService.bootUp();

    var inOrder = inOrder(csmsClient);
    inOrder.verify(csmsClient, times(2)).sendBootNotification(any());
    inOrder.verify(csmsClient, atLeastOnce()).sendStatusNotification(any());
    inOrder.verify(csmsClient, atLeastOnce()).sendHeartbeat(any());
  }


}
