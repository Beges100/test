package com.yablochkov.ocpp2.adapter.csms.dto;

public class StatusNotificationResponse {


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(StatusNotificationResponse.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof StatusNotificationResponse) == false) {
      return false;
    }
    StatusNotificationResponse rhs = ((StatusNotificationResponse) other);
    return true;
  }

}
