package com.sensor.VanessaVictorino_MidtermTest_COMP303.repository;

import com.sensor.VanessaVictorino_MidtermTest_COMP303.model.Sensor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SensorRepository extends MongoRepository<Sensor, String> {
}
