package com.yablochkov.ocpp2.adapter.csms.dto;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class SetVariableResult {

  private AttributeEnumType attributeType = AttributeEnumType.fromValue("Actual");
  /**
   * (Required)
   */
  @NotNull
  private SetVariableResult.SetVariableStatusEnumType attributeStatus;
  /**
   * (Required)
   */
  @Valid
  @NotNull
  private Integer connectorId;
  /**
   * (Required)
   */
  @Valid
  @NotNull
  private String variable;

  /**
   * No args constructor for use in serialization
   */
  public SetVariableResult() {
  }

  /**
   * @param attributeStatus
   * @param connectorId
   * @param attributeType
   * @param variable
   */
  public SetVariableResult(AttributeEnumType attributeType,
      SetVariableStatusEnumType attributeStatus, Integer connectorId, String variable) {
    super();
    this.attributeType = attributeType;
    this.attributeStatus = attributeStatus;
    this.connectorId = connectorId;
    this.variable = variable;
  }

  public AttributeEnumType getAttributeType() {
    return attributeType;
  }

  public void setAttributeType(AttributeEnumType attributeType) {
    this.attributeType = attributeType;
  }

  public SetVariableResult withAttributeType(AttributeEnumType attributeType) {
    this.attributeType = attributeType;
    return this;
  }

  /**
   * (Required)
   */
  public SetVariableStatusEnumType getAttributeStatus() {
    return attributeStatus;
  }

  /**
   * (Required)
   */
  public void setAttributeStatus(SetVariableStatusEnumType attributeStatus) {
    this.attributeStatus = attributeStatus;
  }

  public SetVariableResult withAttributeStatus(SetVariableStatusEnumType attributeStatus) {
    this.attributeStatus = attributeStatus;
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

  public SetVariableResult withConnectorId(Integer connectorId) {
    this.connectorId = connectorId;
    return this;
  }

  /**
   * (Required)
   */
  public String getVariable() {
    return variable;
  }

  /**
   * (Required)
   */
  public void setVariable(String variable) {
    this.variable = variable;
  }

  public SetVariableResult withVariable(String variable) {
    this.variable = variable;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(SetVariableResult.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("attributeType");
    sb.append('=');
    sb.append(((this.attributeType == null) ? "<null>" : this.attributeType));
    sb.append(',');
    sb.append("attributeStatus");
    sb.append('=');
    sb.append(((this.attributeStatus == null) ? "<null>" : this.attributeStatus));
    sb.append(',');
    sb.append("connectorId");
    sb.append('=');
    sb.append(((this.connectorId == null) ? "<null>" : this.connectorId));
    sb.append(',');
    sb.append("variable");
    sb.append('=');
    sb.append(((this.variable == null) ? "<null>" : this.variable));
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
    result = ((result * 31) + ((this.variable == null) ? 0 : this.variable.hashCode()));
    result = ((result * 31) + ((this.attributeStatus == null) ? 0
        : this.attributeStatus.hashCode()));
    result = ((result * 31) + ((this.connectorId == null) ? 0 : this.connectorId.hashCode()));
    result = ((result * 31) + ((this.attributeType == null) ? 0 : this.attributeType.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof SetVariableResult) == false) {
      return false;
    }
    SetVariableResult rhs = ((SetVariableResult) other);
    return (((((this.variable == rhs.variable) || ((this.variable != null) && this.variable.equals(
        rhs.variable))) && ((this.attributeStatus == rhs.attributeStatus) || (
        (this.attributeStatus != null) && this.attributeStatus.equals(rhs.attributeStatus)))) && (
        (this.connectorId
            == rhs.connectorId) || ((this.connectorId
            != null) && this.connectorId.equals(rhs.connectorId)))) && (
        (this.attributeType == rhs.attributeType) || ((this.attributeType != null)
            && this.attributeType.equals(rhs.attributeType))));
  }

  public enum AttributeEnumType {

    ACTUAL("Actual"),
    TARGET("Target"),
    MIN_SET("MinSet"),
    MAX_SET("MaxSet");
    private final String value;
    private final static Map<String, AttributeEnumType> CONSTANTS = new HashMap<String, AttributeEnumType>();

    static {
      for (AttributeEnumType c : values()) {
        CONSTANTS.put(c.value, c);
      }
    }

    AttributeEnumType(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }

    public String value() {
      return this.value;
    }

    public static AttributeEnumType fromValue(String value) {
      AttributeEnumType constant = CONSTANTS.get(value);
      if (constant == null) {
        throw new IllegalArgumentException(value);
      } else {
        return constant;
      }
    }

  }

  public enum SetVariableStatusEnumType {

    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    INVALID_VALUE("InvalidValue"),
    UNKNOWN_CONNECTOR_ID("UnknownConnectorId"),
    UNKNOWN_VARIABLE("UnknownVariable"),
    NOT_SUPPORTED_ATTRIBUTE_TYPE("NotSupportedAttributeType"),
    OUT_OF_RANGE("OutOfRange"),
    REBOOT_REQUIRED("RebootRequired");
    private final String value;
    private final static Map<String, SetVariableStatusEnumType> CONSTANTS = new HashMap<String, SetVariableStatusEnumType>();

    static {
      for (SetVariableStatusEnumType c : values()) {
        CONSTANTS.put(c.value, c);
      }
    }

    SetVariableStatusEnumType(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }

    public String value() {
      return this.value;
    }

    public static SetVariableStatusEnumType fromValue(String value) {
      SetVariableStatusEnumType constant = CONSTANTS.get(value);
      if (constant == null) {
        throw new IllegalArgumentException(value);
      } else {
        return constant;
      }
    }

  }

}
