package com.yablochkov.ocpp2.adapter.rest;

import com.yablochkov.ocpp2.adapter.csms.dto.GetVariablesRequest;
import com.yablochkov.ocpp2.adapter.csms.dto.GetVariablesResponse;
import com.yablochkov.ocpp2.adapter.csms.dto.SetVariablesRequest;
import com.yablochkov.ocpp2.adapter.csms.dto.SetVariablesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OccpController {

  @PostMapping("/variable/set")
  public ResponseEntity<SetVariablesResponse> setVariable(
      @RequestBody SetVariablesRequest request) {
    //TODO implement set variable logic
    return null;
  }

  @GetMapping("/variable/get")
  public ResponseEntity<GetVariablesResponse> getVariable(
      @RequestParam GetVariablesRequest request) {
    //TODO implement get variable logic
    return null;
  }

}
