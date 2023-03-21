package com.yablochkov.ocpp2.adapter.csms.dto;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class GetVariableData {

  private AttributeEnumType attributeType = AttributeEnumType.fromValue("Actual");
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
  public GetVariableData() {
  }

  /**
   * @param connectorId
   * @param attributeType
   * @param variable
   */
  public GetVariableData(AttributeEnumType attributeType, Integer connectorId, String variable) {
    super();
    this.attributeType = attributeType;
    this.connectorId = connectorId;
    this.variable = variable;
  }

  public AttributeEnumType getAttributeType() {
    return attributeType;
  }

  public void setAttributeType(AttributeEnumType attributeType) {
    this.attributeType = attributeType;
  }

  public GetVariableData withAttributeType(AttributeEnumType attributeType) {
    this.attributeType = attributeType;
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

  public GetVariableData withConnectorId(Integer connectorId) {
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

  public GetVariableData withVariable(String variable) {
    this.variable = variable;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(GetVariableData.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("attributeType");
    sb.append('=');
    sb.append(((this.attributeType == null) ? "<null>" : this.attributeType));
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
    result = ((result * 31) + ((this.attributeType == null) ? 0 : this.attributeType.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof GetVariableData) == false) {
      return false;
    }
    GetVariableData rhs = ((GetVariableData) other);
    return ((((this.variable == rhs.variable) || ((this.variable != null) && this.variable.equals(
        rhs.variable))) && ((this.connectorId
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

}
