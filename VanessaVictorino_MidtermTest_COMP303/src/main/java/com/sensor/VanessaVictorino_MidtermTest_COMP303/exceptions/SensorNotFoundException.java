package com.sensor.VanessaVictorino_MidtermTest_COMP303.exceptions;

public class SensorNotFoundException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SensorNotFoundException(String sensorId) {
        super("Sensor not found with ID: " + sensorId);
    }

    public SensorNotFoundException() {
        super("Sensor not found");
    }
}
