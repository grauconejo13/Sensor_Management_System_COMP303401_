package com.sensor.VanessaVictorino_MidtermTest_COMP303.service;

import com.sensor.VanessaVictorino_MidtermTest_COMP303.model.Sensor;
import com.sensor.VanessaVictorino_MidtermTest_COMP303.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Optional;

@Service
public class SensorService {

	private static final Logger logger = LoggerFactory.getLogger(SensorService.class);

    @Autowired
    private SensorRepository sensorRepository;

    public void saveSensor(Sensor sensor) {
        sensorRepository.save(sensor);
    }
    
 // Retrieve a sensor by its ID
    public Optional<Sensor> getSensorById(String sensorId) {
        return sensorRepository.findById(sensorId);
    }

    // Update an existing sensor
    public Sensor updateSensor(String sensorId, Sensor updatedSensor) {
    	  logger.info("Updating sensor with Id: {}", sensorId);
        return sensorRepository.findById(sensorId)
            .map(sensor -> {
                sensor.setSensorName(updatedSensor.getSensorName());
                sensor.setSensorType(updatedSensor.getSensorType());
                sensor.setSensorPin(updatedSensor.getSensorPin());
                sensor.setSensorLocation(updatedSensor.getSensorLocation());
                sensor.setSensorStatus(updatedSensor.getSensorStatus());
                return sensorRepository.save(sensor);
            })
            .orElseThrow(() -> new RuntimeException("Sensor not found with Id " + sensorId));
    }

    // Delete a sensor by its ID
    public void deleteSensorById(String sensorId) {
        sensorRepository.deleteById(sensorId);
        logger.info("Deleted sensor with Id: {}", sensorId);
    }
    
 // Retrieve all sensors
    public List<Sensor> getAllSensors() {
    	 logger.info("Retrieving all sensors");
        return sensorRepository.findAll();
    }
    
}
