package com.yablochkov.ocpp2.adapter.csms.dto;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SetVariableData {

  private AttributeEnumType attributeType = AttributeEnumType.fromValue("Actual");
  /**
   * (Required)
   */
  @Size(max = 1000)
  @NotNull
  private String attributeValue;
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
  public SetVariableData() {
  }

  /**
   * @param connectorId
   * @param attributeValue
   * @param attributeType
   * @param variable
   */
  public SetVariableData(AttributeEnumType attributeType, String attributeValue,
      Integer connectorId, String variable) {
    super();
    this.attributeType = attributeType;
    this.attributeValue = attributeValue;
    this.connectorId = connectorId;
    this.variable = variable;
  }

  public AttributeEnumType getAttributeType() {
    return attributeType;
  }

  public void setAttributeType(AttributeEnumType attributeType) {
    this.attributeType = attributeType;
  }

  public SetVariableData withAttributeType(AttributeEnumType attributeType) {
    this.attributeType = attributeType;
    return this;
  }

  /**
   * (Required)
   */
  public String getAttributeValue() {
    return attributeValue;
  }

  /**
   * (Required)
   */
  public void setAttributeValue(String attributeValue) {
    this.attributeValue = attributeValue;
  }

  public SetVariableData withAttributeValue(String attributeValue) {
    this.attributeValue = attributeValue;
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

  public SetVariableData withConnectorId(Integer connectorId) {
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

  public SetVariableData withVariable(String variable) {
    this.variable = variable;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(SetVariableData.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("attributeType");
    sb.append('=');
    sb.append(((this.attributeType == null) ? "<null>" : this.attributeType));
    sb.append(',');
    sb.append("attributeValue");
    sb.append('=');
    sb.append(((this.attributeValue == null) ? "<null>" : this.attributeValue));
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
    result = ((result * 31) + ((this.connectorId == null) ? 0 : this.connectorId.hashCode()));
    result = ((result * 31) + ((this.attributeValue == null) ? 0 : this.attributeValue.hashCode()));
    result = ((result * 31) + ((this.attributeType == null) ? 0 : this.attributeType.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof SetVariableData) == false) {
      return false;
    }
    SetVariableData rhs = ((SetVariableData) other);
    return (((((this.variable == rhs.variable) || ((this.variable != null) && this.variable.equals(
        rhs.variable))) && ((this.connectorId
        == rhs.connectorId) || ((this.connectorId
        != null) && this.connectorId.equals(rhs.connectorId)))) && (
        (this.attributeValue == rhs.attributeValue) || ((this.attributeValue != null)
            && this.attributeValue.equals(rhs.attributeValue)))) && (
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

}
