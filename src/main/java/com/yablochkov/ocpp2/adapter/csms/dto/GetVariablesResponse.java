package com.yablochkov.ocpp2.adapter.csms.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GetVariablesResponse {

  /**
   * (Required)
   */
  @Size(min = 1)
  @Valid
  @NotNull
  private List<GetVariableResult> getVariableResult;

  /**
   * No args constructor for use in serialization
   */
  public GetVariablesResponse() {
  }

  /**
   * @param getVariableResult
   */
  public GetVariablesResponse(List<GetVariableResult> getVariableResult) {
    super();
    this.getVariableResult = getVariableResult;
  }

  /**
   * (Required)
   */
  public List<GetVariableResult> getGetVariableResult() {
    return getVariableResult;
  }

  /**
   * (Required)
   */
  public void setGetVariableResult(List<GetVariableResult> getVariableResult) {
    this.getVariableResult = getVariableResult;
  }

  public GetVariablesResponse withGetVariableResult(List<GetVariableResult> getVariableResult) {
    this.getVariableResult = getVariableResult;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(GetVariablesResponse.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("getVariableResult");
    sb.append('=');
    sb.append(((this.getVariableResult == null) ? "<null>" : this.getVariableResult));
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
    result = ((result * 31) + ((this.getVariableResult == null) ? 0
        : this.getVariableResult.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof GetVariablesResponse) == false) {
      return false;
    }
    GetVariablesResponse rhs = ((GetVariablesResponse) other);
    return ((this.getVariableResult == rhs.getVariableResult) || ((this.getVariableResult != null)
        && this.getVariableResult.equals(rhs.getVariableResult)));
  }

}
