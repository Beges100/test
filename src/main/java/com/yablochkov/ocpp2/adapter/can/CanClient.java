package com.yablochkov.ocpp2.adapter.can;

public interface CanClient {

  boolean hasConnectorFailure(Integer connectorId);

  boolean isConnectorInserted(Integer connectorId);

}

