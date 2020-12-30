package com.example.RestApp3.Service.IMPL;

import com.example.RestApp3.Models.Alert;
import com.example.RestApp3.Models.Sensor;
import com.example.RestApp3.Models.SensorData;
import com.example.RestApp3.Repos.AlertRepo;
import com.example.RestApp3.Repos.SensorReadingRepo;
import com.example.RestApp3.Service.AlertGeneratorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.*;
@Component
public class AlertGenerater implements AlertGeneratorRepo {

    @Autowired
    SensorReadingRepo dataRepo;
    @Autowired
    AlertRepo alertRepo;
    List<SensorData> sensorDatas=new ArrayList<>();
    SensorData data;
    Sensor sensor;
    private long sigId=0;
    private long preSigId=0;
    @Scheduled(cron = "*/5 * * * * *")
    public void notifyTemp(){
        try {
            sensorDatas = dataRepo.findAll();
            data = sensorDatas.get(sensorDatas.size() - 1);
            sensor = data.getSensor();
            sigId = data.getSigId();
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            if (sigId != preSigId) {
                if (data.getDataValue() > sensor.getThreshold()) {
                    Alert alert = new Alert(data.getSensorId(), sensor, sensor.getSensorName() + " reading value is too high", data.getTimestamp());
                    alertRepo.save(alert);
                    System.out.println(sensor.getSensorName() + " reading value is too high");
                    System.out.println("Warning Email/SMS sent");
                } else {
                    System.out.println(sensor.getSensorName() + " reading value is normal");
                    Alert alert = new Alert(data.getSensorId(), sensor, sensor.getSensorName() + " reading value is normal", data.getTimestamp());
                    alertRepo.save(alert);
                }
                preSigId = sigId;
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("Database is empty , Please insert data to the database");
        }
    }
}
