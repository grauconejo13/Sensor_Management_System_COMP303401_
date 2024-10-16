package com.sensor.VanessaVictorino_MidtermTest_COMP303.service;

import com.sensor.VanessaVictorino_MidtermTest_COMP303.model.Sensor;
import com.sensor.VanessaVictorino_MidtermTest_COMP303.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> getAllSensors() {
        return sensorRepository.findAll();
    }

    public void saveSensor(Sensor sensor) {
        sensorRepository.save(sensor);
    }
}
