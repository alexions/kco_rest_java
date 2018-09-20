/*
 * 
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.klarna.rest.model.checkout;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * MerchantRequested
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-06T10:31:49.433Z")
public class MerchantRequested {
  @JsonProperty("additional_checkbox")
  private Boolean additionalCheckbox = false;

  @JsonProperty("additional_checkboxes")
  private List<MerchantRequestedCheckbox> additionalCheckboxes = null;

   /**
   * Informs whether the additional_checkbox is checked or not, when applicable.
   * @return additionalCheckbox
  **/
  @ApiModelProperty(value = "Informs whether the additional_checkbox is checked or not, when applicable.")
  public Boolean isAdditionalCheckbox() {
    return additionalCheckbox;
  }

   /**
   * Informs whether the additional_checkboxes is checked or not, when applicable.
   * @return additionalCheckboxes
  **/
  @ApiModelProperty(value = "Informs whether the additional_checkboxes is checked or not, when applicable.")
  public List<MerchantRequestedCheckbox> getAdditionalCheckboxes() {
    return additionalCheckboxes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MerchantRequested merchantRequested = (MerchantRequested) o;
    return Objects.equals(this.additionalCheckbox, merchantRequested.additionalCheckbox) &&
        Objects.equals(this.additionalCheckboxes, merchantRequested.additionalCheckboxes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalCheckbox, additionalCheckboxes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MerchantRequested {\n");
    
    sb.append("    additionalCheckbox: ").append(toIndentedString(additionalCheckbox)).append("\n");
    sb.append("    additionalCheckboxes: ").append(toIndentedString(additionalCheckboxes)).append("\n");
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
