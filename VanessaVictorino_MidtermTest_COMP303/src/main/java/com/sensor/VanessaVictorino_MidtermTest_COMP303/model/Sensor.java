package com.sensor.VanessaVictorino_MidtermTest_COMP303.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "Sensor")
public class Sensor {
    @Id
    private String sensorId;

    @NotBlank(message = "Sensor name is required")
    private String sensorName;

    @NotBlank(message = "Sensor type is required")
    private String sensorType;

    @NotNull(message = "Sensor pin is required")
    @Min(value = 0, message = "Sensor pin must be between 0 and 1000")
    @Max(value = 1000, message = "Sensor pin must be between 0 and 1000")
    private Integer sensorPin;

    private String sensorLocation;

    @NotNull(message = "Sensor status is required")
    private String sensorStatus;

 // Getter and Setter for sensorName
    
 // Getter and Setter for id
   

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    } 
    public String getSensorId() {
        return sensorId;
    }
    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    // Getter and Setter for sensorType
    public String getSensorType() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }

    // Getter and Setter for sensorPin
    public Integer getSensorPin() {
        return sensorPin;
    }

    public void setSensorPin(Integer sensorPin) {
        this.sensorPin = sensorPin;
    }

    // Getter and Setter for sensorLocation
    public String getSensorLocation() {
        return sensorLocation;
    }

    public void setSensorLocation(String sensorLocation) {
        this.sensorLocation = sensorLocation;
    }

    // Getter and Setter for sensorStatus
    public String getSensorStatus() {
        return sensorStatus;
    }

    public void setSensorStatus(String sensorStatus) {
        this.sensorStatus = sensorStatus;
    }
}


