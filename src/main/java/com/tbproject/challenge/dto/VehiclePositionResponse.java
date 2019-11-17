package com.tbproject.challenge.dto;

import javax.validation.Valid;


import io.swagger.annotations.*;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;


public class VehiclePositionResponse {
  private @Valid String vehicleId = null;
  private @Valid String longitude = null;
  private @Valid String latitude = null;

  /**
   **/
  public VehiclePositionResponse vehicleId(String vehicleId) {
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
  public VehiclePositionResponse longitude(String longitude) {
    this.longitude = longitude;
    return this;
  }

  
  @ApiModelProperty(example = "-6.257359", value = "")
  @JsonProperty("longitude")

  public String getLongitude() {
    return longitude;
  }
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  /**
   **/
  public VehiclePositionResponse latitude(String latitude) {
    this.latitude = latitude;
    return this;
  }

  
  @ApiModelProperty(example = "53.373501", value = "")
  @JsonProperty("latitude")

  public String getLatitude() {
    return latitude;
  }
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VehiclePositionResponse vehiclePositionResponse = (VehiclePositionResponse) o;
    return Objects.equals(vehicleId, vehiclePositionResponse.vehicleId) &&
        Objects.equals(longitude, vehiclePositionResponse.longitude) &&
        Objects.equals(latitude, vehiclePositionResponse.latitude);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleId, longitude, latitude);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse2003 {\n");
    
    sb.append("    vehicleId: ").append(toIndentedString(vehicleId)).append("\n");
    sb.append("    longitude: ").append(toIndentedString(longitude)).append("\n");
    sb.append("    latitude: ").append(toIndentedString(latitude)).append("\n");
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
