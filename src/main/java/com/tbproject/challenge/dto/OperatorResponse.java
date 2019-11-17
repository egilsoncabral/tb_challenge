package com.tbproject.challenge.dto;

import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class OperatorResponse {
  private @Valid String operator = null;

  /**
   **/
  public OperatorResponse operator(String operator) {
    this.operator = operator;
    return this;
  }

  
  @ApiModelProperty(example = "RD", value = "")
  @JsonProperty("operator")
  public String getOperator() {
    return operator;
  }
  public void setOperator(String operator) {
    this.operator = operator;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OperatorResponse operatorResponse = (OperatorResponse) o;
    return Objects.equals(operator, operatorResponse.operator);
  }

  @Override
  public int hashCode() {
    return Objects.hash(operator);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
