package com.yablochkov.ocpp2.adapter.csms;

import com.yablochkov.ocpp2.adapter.csms.dto.BootNotificationRequest;
import com.yablochkov.ocpp2.adapter.csms.dto.BootNotificationResponse;
import com.yablochkov.ocpp2.adapter.csms.dto.HeartbeatRequest;
import com.yablochkov.ocpp2.adapter.csms.dto.HeartbeatResponse;
import com.yablochkov.ocpp2.adapter.csms.dto.StatusNotificationRequest;
import com.yablochkov.ocpp2.adapter.csms.dto.StatusNotificationResponse;

public interface CsmsClient {

  BootNotificationResponse sendBootNotification(BootNotificationRequest bootNotificationRequest);

  StatusNotificationResponse sendStatusNotification(
      StatusNotificationRequest statusNotificationRequest);

  HeartbeatResponse sendHeartbeat(HeartbeatRequest heartbeatRequest);

}
