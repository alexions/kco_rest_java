/*
 * Klarna Settlements API
 * This API gives you access to your payouts and transactions.     Resources are split into two broad types:     * Collections, including pagination information:      collections are queryable, typically by the attributes of the sub-resource      as well as pagination.    * Entity resources containing a single entity.
 *
 * OpenAPI spec version: 1.0.0-rc2
 * Contact: integration@klarna.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.klarna.rest.model.settlements;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

/**
 * PayoutCollection
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2018-09-28T11:11:59.241Z")
public class PayoutCollection {
  @JsonProperty("payouts")
  private List<Payout> payouts = new ArrayList<Payout>();

  @JsonProperty("pagination")
  private Pagination pagination = null;

  public PayoutCollection payouts(List<Payout> payouts) {
    this.payouts = payouts;
    return this;
  }

  public PayoutCollection addPayoutsItem(Payout payoutsItem) {
    this.payouts.add(payoutsItem);
    return this;
  }

   /**
   * Get payouts
   * @return payouts
  **/
  @ApiModelProperty(required = true, value = "")
  public List<Payout> getPayouts() {
    return payouts;
  }

  public void setPayouts(List<Payout> payouts) {
    this.payouts = payouts;
  }

  public PayoutCollection pagination(Pagination pagination) {
    this.pagination = pagination;
    return this;
  }

   /**
   * Get pagination
   * @return pagination
  **/
  @ApiModelProperty(required = true, value = "")
  public Pagination getPagination() {
    return pagination;
  }

  public void setPagination(Pagination pagination) {
    this.pagination = pagination;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PayoutCollection payoutCollection = (PayoutCollection) o;
    return Objects.equals(this.payouts, payoutCollection.payouts) &&
        Objects.equals(this.pagination, payoutCollection.pagination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payouts, pagination);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayoutCollection {\n");
    
    sb.append("    payouts: ").append(toIndentedString(payouts)).append("\n");
    sb.append("    pagination: ").append(toIndentedString(pagination)).append("\n");
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
