package com.yablochkov.ocpp2.adapter.csms.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import javax.validation.constraints.NotNull;

public class StatusNotificationRequest {

  /**
   * (Required)
   */
  @NotNull
  private LocalDateTime timestamp;
  /**
   * (Required)
   */
  @NotNull
  private StatusNotificationRequest.ConnectorStatus connectorStatus;
  /**
   * (Required)
   */
  @NotNull
  private Integer evseId;
  /**
   * (Required)
   */
  @NotNull
  private Integer connectorId;

  /**
   * No args constructor for use in serialization
   */
  public StatusNotificationRequest() {
  }

  /**
   * @param evseId
   * @param connectorId
   * @param connectorStatus
   * @param timestamp
   */
  public StatusNotificationRequest(LocalDateTime timestamp, ConnectorStatus connectorStatus,
      Integer evseId, Integer connectorId) {
    super();
    this.timestamp = timestamp;
    this.connectorStatus = connectorStatus;
    this.evseId = evseId;
    this.connectorId = connectorId;
  }

  /**
   * (Required)
   */
  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  /**
   * (Required)
   */
  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }

  public StatusNotificationRequest withTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * (Required)
   */
  public ConnectorStatus getConnectorStatus() {
    return connectorStatus;
  }

  /**
   * (Required)
   */
  public void setConnectorStatus(ConnectorStatus connectorStatus) {
    this.connectorStatus = connectorStatus;
  }

  public StatusNotificationRequest withConnectorStatus(ConnectorStatus connectorStatus) {
    this.connectorStatus = connectorStatus;
    return this;
  }

  /**
   * (Required)
   */
  public Integer getEvseId() {
    return evseId;
  }

  /**
   * (Required)
   */
  public void setEvseId(Integer evseId) {
    this.evseId = evseId;
  }

  public StatusNotificationRequest withEvseId(Integer evseId) {
    this.evseId = evseId;
    return this;
  }

  /**
   * (Required)
   */
  public Integer getConnectorId() {
    return connectorId;
  }

  /**
   * (Required)
   */
  public void setConnectorId(Integer connectorId) {
    this.connectorId = connectorId;
  }

  public StatusNotificationRequest withConnectorId(Integer connectorId) {
    this.connectorId = connectorId;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(StatusNotificationRequest.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("timestamp");
    sb.append('=');
    sb.append(((this.timestamp == null) ? "<null>" : this.timestamp));
    sb.append(',');
    sb.append("connectorStatus");
    sb.append('=');
    sb.append(((this.connectorStatus == null) ? "<null>" : this.connectorStatus));
    sb.append(',');
    sb.append("evseId");
    sb.append('=');
    sb.append(((this.evseId == null) ? "<null>" : this.evseId));
    sb.append(',');
    sb.append("connectorId");
    sb.append('=');
    sb.append(((this.connectorId == null) ? "<null>" : this.connectorId));
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = ((result * 31) + ((this.evseId == null) ? 0 : this.evseId.hashCode()));
    result = ((result * 31) + ((this.connectorStatus == null) ? 0
        : this.connectorStatus.hashCode()));
    result = ((result * 31) + ((this.connectorId == null) ? 0 : this.connectorId.hashCode()));
    result = ((result * 31) + ((this.timestamp == null) ? 0 : this.timestamp.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof StatusNotificationRequest) == false) {
      return false;
    }
    StatusNotificationRequest rhs = ((StatusNotificationRequest) other);
    return (
        ((((this.evseId == rhs.evseId) || ((this.evseId != null) && this.evseId.equals(rhs.evseId)))
            && ((this.connectorStatus == rhs.connectorStatus) || ((this.connectorStatus != null)
            && this.connectorStatus.equals(rhs.connectorStatus)))) && (
            (this.connectorId == rhs.connectorId) || ((this.connectorId != null)
                && this.connectorId.equals(rhs.connectorId)))) && ((this.timestamp == rhs.timestamp)
            || ((this.timestamp != null) && this.timestamp.equals(rhs.timestamp))));
  }

  public enum ConnectorStatus {

    AVAILABLE("Available"),
    OCCUPIED("Occupied"),
    FAULTED("Faulted");
    private final String value;
    private final static Map<String, ConnectorStatus> CONSTANTS = new HashMap<String, ConnectorStatus>();

    static {
      for (ConnectorStatus c : values()) {
        CONSTANTS.put(c.value, c);
      }
    }

    ConnectorStatus(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }

    public String value() {
      return this.value;
    }

    public static ConnectorStatus fromValue(String value) {
      ConnectorStatus constant = CONSTANTS.get(value);
      if (constant == null) {
        throw new IllegalArgumentException(value);
      } else {
        return constant;
      }
    }

  }

}
