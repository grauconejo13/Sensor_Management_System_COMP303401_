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
    public String addSensor(@Valid @ModelAttribute Sensor sensor) {
        sensorService.saveSensor(sensor);
        return "redirect:/";
    }
    
    // Display form for editing an existing sensor
    @GetMapping("/editSensor/{sensorId}")
    public String editSensorForm(@PathVariable("sensorId") String sensorId, Model model) {
        sensorService.getSensorById(sensorId).ifPresent(sensor -> model.addAttribute("sensor", sensor));
        return "editSensor";
    }

    // Update a sensor after editing
    @PostMapping("/editSensor")
    public String updateSensor(@ModelAttribute Sensor sensor) {
        sensorService.saveSensor(sensor);
        return "redirect:/";
    }

    // Delete a sensor by ID
    @PostMapping("/deleteSensor/{sensorId}")
    public String deleteSensor(@PathVariable("sensorId") String sensorId) {
        sensorService.deleteSensorById(sensorId);
        return "redirect:/";
    }
}
