package com.sensor.VanessaVictorino_MidtermTest_COMP303.controller;

import com.sensor.VanessaVictorino_MidtermTest_COMP303.model.Sensor;
import com.sensor.VanessaVictorino_MidtermTest_COMP303.service.SensorService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SensorController {

    @Autowired
    private SensorService sensorService;
  
    @GetMapping("/")
    public String showAllSensors(Model model) {
        List<Sensor> sensors = sensorService.getAllSensors();
        model.addAttribute("sensors", sensors);
        model.addAttribute("totalSensors", sensors.size());
        return "sensorList";
    }

    @GetMapping("/addSensor")
    public String addSensorForm(Model model) {
        model.addAttribute("sensor", new Sensor());
        return "addSensor";
    }

    @PostMapping("/addSensor")
    public String addSensor(@Valid @ModelAttribute("sensor") Sensor sensor) {
        sensorService.saveSensor(sensor);
        return "redirect:/";
    }
}
