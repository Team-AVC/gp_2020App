package com.example.RestApp3.Controllers;

import com.example.RestApp3.Models.Sensor;
import com.example.RestApp3.Models.SensorData;
import com.example.RestApp3.Repos.SensorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class SensorDataController {

    @Autowired
    SensorRepo sensorRepo;

    @RequestMapping("/sensor")
    public String func1(){

        return "from index func";
    }


    //get all data
    @RequestMapping("port/sensor")
    public List<Sensor> getAll(){
        return sensorRepo.findAll();
    }

    @RequestMapping("port/sensor/{sensorid}")
    public List<Sensor> getDataPerSensor(@PathVariable("sensorid")long id){

        return sensorRepo.getSignalsOfSensorId(id);
    }

}
