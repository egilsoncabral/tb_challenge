package com.tbproject.challenge.dto;

import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class VehicleResponse {
  private @Valid String vehicleId = null;

  /**
   **/
  public VehicleResponse vehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
    return this;
  }

  
  @ApiModelProperty(example = "345241", value = "")
  @JsonProperty("vehicleId")

  public String getVehicleId() {
    return vehicleId;
  }
  public void setVehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleResponse vehicleResponse = (VehicleResponse) o;
    return Objects.equals(vehicleId, vehicleResponse.vehicleId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2001 {\n");
    
    sb.append("    vehicleId: ").append(toIndentedString(vehicleId)).append("\n");
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
