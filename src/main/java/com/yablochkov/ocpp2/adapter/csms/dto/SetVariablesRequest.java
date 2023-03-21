package com.yablochkov.ocpp2.adapter.csms.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SetVariablesRequest {

  /**
   * (Required)
   */
  @Size(min = 1)
  @Valid
  @NotNull
  private List<SetVariableData> setVariableData;

  /**
   * No args constructor for use in serialization
   */
  public SetVariablesRequest() {
  }

  /**
   * @param setVariableData
   */
  public SetVariablesRequest(List<SetVariableData> setVariableData) {
    super();
    this.setVariableData = setVariableData;
  }

  /**
   * (Required)
   */
  public List<SetVariableData> getSetVariableData() {
    return setVariableData;
  }

  /**
   * (Required)
   */
  public void setSetVariableData(List<SetVariableData> setVariableData) {
    this.setVariableData = setVariableData;
  }

  public SetVariablesRequest withSetVariableData(List<SetVariableData> setVariableData) {
    this.setVariableData = setVariableData;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(SetVariablesRequest.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("setVariableData");
    sb.append('=');
    sb.append(((this.setVariableData == null) ? "<null>" : this.setVariableData));
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
    result = ((result * 31) + ((this.setVariableData == null) ? 0
        : this.setVariableData.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof SetVariablesRequest) == false) {
      return false;
    }
    SetVariablesRequest rhs = ((SetVariablesRequest) other);
    return ((this.setVariableData == rhs.setVariableData) || ((this.setVariableData != null)
        && this.setVariableData.equals(rhs.setVariableData)));
  }

}
