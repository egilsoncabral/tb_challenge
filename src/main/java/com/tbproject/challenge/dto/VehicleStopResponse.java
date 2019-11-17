package com.tbproject.challenge.dto;

import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class VehicleStopResponse {
  private @Valid String vehicleId = null;
  private @Valid Boolean atStop = null;

  /**
   **/
  public VehicleStopResponse vehicleId(String vehicleId) {
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

  /**
   **/
  public VehicleStopResponse atStop(Boolean atStop) {
    this.atStop = atStop;
    return this;
  }

  
  @ApiModelProperty(example = "true", value = "")
  @JsonProperty("atStop")

  public Boolean isAtStop() {
    return atStop;
  }
  public void setAtStop(Boolean atStop) {
    this.atStop = atStop;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehicleStopResponse vehicleStopResponse = (VehicleStopResponse) o;
    return Objects.equals(vehicleId, vehicleStopResponse.vehicleId) &&
        Objects.equals(atStop, vehicleStopResponse.atStop);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleId, atStop);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2002 {\n");
    
    sb.append("    vehicleId: ").append(toIndentedString(vehicleId)).append("\n");
    sb.append("    atStop: ").append(toIndentedString(atStop)).append("\n");
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
