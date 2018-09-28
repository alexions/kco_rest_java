/*
 * HPP
 * Hosted payment page
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.klarna.rest.model.hosted_payment_page;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModelProperty;

/**
 * DistributionRequestV1
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-28T10:02:28.819Z")
public class DistributionRequestV1 {
  @JsonProperty("contact_information")
  private DistributionContactV1 contactInformation = null;

  /**
   * Method used for distribution
   */
  public enum MethodEnum {
    SMS("sms"),
    
    EMAIL("email");

    private String value;

    MethodEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static MethodEnum fromValue(String text) {
      for (MethodEnum b : MethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("method")
  private MethodEnum method = null;

  /**
   * Gets or Sets template
   */
  public enum TemplateEnum {
    INSTORE_PURCHASE("INSTORE_PURCHASE");

    private String value;

    TemplateEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TemplateEnum fromValue(String text) {
      for (TemplateEnum b : TemplateEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("template")
  private TemplateEnum template = null;

  public DistributionRequestV1 contactInformation(DistributionContactV1 contactInformation) {
    this.contactInformation = contactInformation;
    return this;
  }

   /**
   * Contact information for the link distribution
   * @return contactInformation
  **/
  @ApiModelProperty(required = true, value = "Contact information for the link distribution")
  public DistributionContactV1 getContactInformation() {
    return contactInformation;
  }

  public void setContactInformation(DistributionContactV1 contactInformation) {
    this.contactInformation = contactInformation;
  }

  public DistributionRequestV1 method(MethodEnum method) {
    this.method = method;
    return this;
  }

   /**
   * Method used for distribution
   * @return method
  **/
  @ApiModelProperty(example = "sms", required = true, value = "Method used for distribution")
  public MethodEnum getMethod() {
    return method;
  }

  public void setMethod(MethodEnum method) {
    this.method = method;
  }

  public DistributionRequestV1 template(TemplateEnum template) {
    this.template = template;
    return this;
  }

   /**
   * Get template
   * @return template
  **/
  @ApiModelProperty(required = true, value = "")
  public TemplateEnum getTemplate() {
    return template;
  }

  public void setTemplate(TemplateEnum template) {
    this.template = template;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DistributionRequestV1 distributionRequestV1 = (DistributionRequestV1) o;
    return Objects.equals(this.contactInformation, distributionRequestV1.contactInformation) &&
        Objects.equals(this.method, distributionRequestV1.method) &&
        Objects.equals(this.template, distributionRequestV1.template);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactInformation, method, template);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DistributionRequestV1 {\n");
    
    sb.append("    contactInformation: ").append(toIndentedString(contactInformation)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
