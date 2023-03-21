package com.yablochkov.ocpp2.adapter.csms.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SetVariablesResponse {

  /**
   * (Required)
   */
  @Size(min = 1)
  @Valid
  @NotNull
  private List<SetVariableResult> setVariableResult;

  /**
   * No args constructor for use in serialization
   */
  public SetVariablesResponse() {
  }

  /**
   * @param setVariableResult
   */
  public SetVariablesResponse(List<SetVariableResult> setVariableResult) {
    super();
    this.setVariableResult = setVariableResult;
  }

  /**
   * (Required)
   */
  public List<SetVariableResult> getSetVariableResult() {
    return setVariableResult;
  }

  /**
   * (Required)
   */
  public void setSetVariableResult(List<SetVariableResult> setVariableResult) {
    this.setVariableResult = setVariableResult;
  }

  public SetVariablesResponse withSetVariableResult(List<SetVariableResult> setVariableResult) {
    this.setVariableResult = setVariableResult;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(SetVariablesResponse.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("setVariableResult");
    sb.append('=');
    sb.append(((this.setVariableResult == null) ? "<null>" : this.setVariableResult));
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
    result = ((result * 31) + ((this.setVariableResult == null) ? 0
        : this.setVariableResult.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof SetVariablesResponse) == false) {
      return false;
    }
    SetVariablesResponse rhs = ((SetVariablesResponse) other);
    return ((this.setVariableResult == rhs.setVariableResult) || ((this.setVariableResult != null)
        && this.setVariableResult.equals(rhs.setVariableResult)));
  }

}
