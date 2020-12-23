package com.example.RestApp3.Service.IMPL;

import com.example.RestApp3.Models.SensorData;
import com.example.RestApp3.Repos.TemperatureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.*;
@Component
public class DatabaseChecker {

    @Autowired
    TemperatureRepo dataRepo;
    List<SensorData> sensorDatas=new ArrayList<>();
    SensorData data;
    private long sigId=0;
    private long preSigId=0;
    @Scheduled(cron = "*/5 * * * * *")
    public void notifyTemp(){
        sensorDatas=dataRepo.findAll();
        data=sensorDatas.get(sensorDatas.size()-1);
        sigId=data.getSigId();
        if(sigId!=preSigId) {
            if (data.getDataValue() > 30) {
                System.out.println("Temperature Level is too high");
                System.out.println("Warning Email/SMS sent");
            }else{
                System.out.println("Temperature Level is normal");
            }
            preSigId=sigId;
        }
    }
}
