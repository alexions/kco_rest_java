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


package com.klarna.rest.model.payments;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * Attachment
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-28T14:31:36.430Z")
public class Attachment {
  @JsonProperty("content_type")
  private String contentType = null;

  @JsonProperty("body")
  private String body = null;

  public Attachment contentType(String contentType) {
    this.contentType = contentType;
    return this;
  }

   /**
   * The content type of the body property.
   * @return contentType
  **/
  @ApiModelProperty(example = "application/vnd.klarna.internal.emd-v2+json", required = true, value = "The content type of the body property.")
  public String getContentType() {
    return contentType;
  }

  public void setContentType(String contentType) {
    this.contentType = contentType;
  }

  public Attachment body(String body) {
    this.body = body;
    return this;
  }

   /**
   * This field should be a &lt;b&gt;string&lt;/b&gt; containing the body of the attachment. The body should be an object containing any of the keys and sub objects described below serialised to JSON.
   * @return body
  **/
  @ApiModelProperty(example = "{\"marketplace_seller_info\":[{\"product_category\":\"Women's Fashion\",\"product_name\":\"Women Sweatshirt\"}]}", required = true, value = "This field should be a <b>string</b> containing the body of the attachment. The body should be an object containing any of the keys and sub objects described below serialised to JSON.")
  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Attachment attachment = (Attachment) o;
    return Objects.equals(this.contentType, attachment.contentType) &&
        Objects.equals(this.body, attachment.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contentType, body);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Attachment {\n");
    
    sb.append("    contentType: ").append(toIndentedString(contentType)).append("\n");
    sb.append("    body: ").append(toIndentedString(body)).append("\n");
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
