package com.yablochkov.ocpp2.adapter.csms.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GetVariablesRequest {

  /**
   * (Required)
   */
  @Size(min = 1)
  @Valid
  @NotNull
  private List<GetVariableData> getVariableData;

  /**
   * No args constructor for use in serialization
   */
  public GetVariablesRequest() {
  }

  /**
   * @param getVariableData
   */
  public GetVariablesRequest(List<GetVariableData> getVariableData) {
    super();
    this.getVariableData = getVariableData;
  }

  /**
   * (Required)
   */
  public List<GetVariableData> getGetVariableData() {
    return getVariableData;
  }

  /**
   * (Required)
   */
  public void setGetVariableData(List<GetVariableData> getVariableData) {
    this.getVariableData = getVariableData;
  }

  public GetVariablesRequest withGetVariableData(List<GetVariableData> getVariableData) {
    this.getVariableData = getVariableData;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(GetVariablesRequest.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("getVariableData");
    sb.append('=');
    sb.append(((this.getVariableData == null) ? "<null>" : this.getVariableData));
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
    result = ((result * 31) + ((this.getVariableData == null) ? 0
        : this.getVariableData.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof GetVariablesRequest) == false) {
      return false;
    }
    GetVariablesRequest rhs = ((GetVariablesRequest) other);
    return ((this.getVariableData == rhs.getVariableData) || ((this.getVariableData != null)
        && this.getVariableData.equals(rhs.getVariableData)));
  }

}
