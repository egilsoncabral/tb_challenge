package com.tbproject.challenge.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * VehicleStopResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-11-18T23:54:00.718Z")

public class VehicleStopResponse   {
  @JsonProperty("vehicleId")
  private String vehicleId = null;

  @JsonProperty("atStop")
  private Boolean atStop = null;

  public VehicleStopResponse vehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
    return this;
  }

  /**
   * Get vehicleId
   * @return vehicleId
  **/
  @ApiModelProperty(example = "12233", value = "")


  public String getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
  }

  public VehicleStopResponse atStop(Boolean atStop) {
    this.atStop = atStop;
    return this;
  }

  /**
   * Get atStop
   * @return atStop
  **/
  @ApiModelProperty(example = "true", value = "")


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
    return Objects.equals(this.vehicleId, vehicleStopResponse.vehicleId) &&
        Objects.equals(this.atStop, vehicleStopResponse.atStop);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vehicleId, atStop);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VehicleStopResponse {\n");
    
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

