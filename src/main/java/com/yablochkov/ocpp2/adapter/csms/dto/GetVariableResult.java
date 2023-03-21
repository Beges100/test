package com.yablochkov.ocpp2.adapter.csms.dto;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GetVariableResult {

  /**
   * (Required)
   */
  @NotNull
  private GetVariableResult.GetVariableStatusEnumType attributeStatus;
  private AttributeEnumType attributeType = AttributeEnumType.fromValue("Actual");
  @Size(max = 1000)
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
  private String attributeName;

  /**
   * No args constructor for use in serialization
   */
  public GetVariableResult() {
  }

  /**
   * @param attributeStatus
   * @param connectorId
   * @param attributeValue
   * @param attributeType
   * @param attributeName
   */
  public GetVariableResult(GetVariableStatusEnumType attributeStatus,
      AttributeEnumType attributeType, String attributeValue, Integer connectorId,
      String attributeName) {
    super();
    this.attributeStatus = attributeStatus;
    this.attributeType = attributeType;
    this.attributeValue = attributeValue;
    this.connectorId = connectorId;
    this.attributeName = attributeName;
  }

  /**
   * (Required)
   */
  public GetVariableStatusEnumType getAttributeStatus() {
    return attributeStatus;
  }

  /**
   * (Required)
   */
  public void setAttributeStatus(GetVariableStatusEnumType attributeStatus) {
    this.attributeStatus = attributeStatus;
  }

  public GetVariableResult withAttributeStatus(GetVariableStatusEnumType attributeStatus) {
    this.attributeStatus = attributeStatus;
    return this;
  }

  public AttributeEnumType getAttributeType() {
    return attributeType;
  }

  public void setAttributeType(AttributeEnumType attributeType) {
    this.attributeType = attributeType;
  }

  public GetVariableResult withAttributeType(AttributeEnumType attributeType) {
    this.attributeType = attributeType;
    return this;
  }

  public String getAttributeValue() {
    return attributeValue;
  }

  public void setAttributeValue(String attributeValue) {
    this.attributeValue = attributeValue;
  }

  public GetVariableResult withAttributeValue(String attributeValue) {
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

  public GetVariableResult withConnectorId(Integer connectorId) {
    this.connectorId = connectorId;
    return this;
  }

  /**
   * (Required)
   */
  public String getAttributeName() {
    return attributeName;
  }

  /**
   * (Required)
   */
  public void setAttributeName(String attributeName) {
    this.attributeName = attributeName;
  }

  public GetVariableResult withVariable(String variable) {
    this.attributeName = variable;
    return this;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(GetVariableResult.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("attributeStatus");
    sb.append('=');
    sb.append(((this.attributeStatus == null) ? "<null>" : this.attributeStatus));
    sb.append(',');
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
    sb.append("attributeName");
    sb.append('=');
    sb.append(((this.attributeName == null) ? "<null>" : this.attributeName));
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
    result = ((result * 31) + ((this.attributeName == null) ? 0 : this.attributeName.hashCode()));
    result = ((result * 31) + ((this.attributeStatus == null) ? 0
        : this.attributeStatus.hashCode()));
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
    if ((other instanceof GetVariableResult) == false) {
      return false;
    }
    GetVariableResult rhs = ((GetVariableResult) other);
    return ((((((this.attributeName == rhs.attributeName) || ((this.attributeName
        != null) && this.attributeName.equals(rhs.attributeName))) && (
        (this.attributeStatus == rhs.attributeStatus) || ((this.attributeStatus != null)
            && this.attributeStatus.equals(rhs.attributeStatus)))) && ((this.connectorId
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

  public enum GetVariableStatusEnumType {

    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    UNKNOWN_CONNECTOR_ID("UnknownConnectorId"),
    UNKNOWN_VARIABLE("UnknownVariable"),
    NOT_SUPPORTED_ATTRIBUTE_TYPE("NotSupportedAttributeType");
    private final String value;
    private final static Map<String, GetVariableStatusEnumType> CONSTANTS = new HashMap<String, GetVariableStatusEnumType>();

    static {
      for (GetVariableStatusEnumType c : values()) {
        CONSTANTS.put(c.value, c);
      }
    }

    GetVariableStatusEnumType(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return this.value;
    }

    public String value() {
      return this.value;
    }

    public static GetVariableStatusEnumType fromValue(String value) {
      GetVariableStatusEnumType constant = CONSTANTS.get(value);
      if (constant == null) {
        throw new IllegalArgumentException(value);
      } else {
        return constant;
      }
    }

  }

}
