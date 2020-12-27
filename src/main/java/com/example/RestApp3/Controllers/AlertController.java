package com.example.RestApp3.Controllers;

import com.example.RestApp3.Models.Alert;
import com.example.RestApp3.Models.Sensor;
import com.example.RestApp3.Repos.AlertRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin
@RestController
public class AlertController {

    @Autowired
    AlertRepo alertRepo;

    @RequestMapping("/alert")
    public String func1(){

        return "from index func";
    }


    //get all data
    @RequestMapping("port/alert")
    public List<Alert> getAll(){
        return alertRepo.findAll();
    }

    @RequestMapping("port/alert/{sensorid}")
    public List<Alert> getDataPerSensor(@PathVariable("sensorid")long id){

        return alertRepo.getSignalsOfSensorId(id);
    }

}
