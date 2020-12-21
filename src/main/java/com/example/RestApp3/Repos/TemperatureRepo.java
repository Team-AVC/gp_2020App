package com.example.RestApp3.Repos;

import com.example.RestApp3.Models.MyDataClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Date;
import java.util.List;

public interface TemperatureRepo extends JpaRepository<MyDataClass,Integer> {

    @Query("from MyDataClass where dataValue< ?1 or dataValue> ?2")
    public List<MyDataClass>getOutOfRange(int lower,int higher);

    @Query("from MyDataClass where dataValue> ?1 and dataValue< ?2")
    public List<MyDataClass>getInRange(int lower,int higher);

    @Query("from MyDataClass where sensorId= ?1 order by date")
    public List<MyDataClass>getSignalsOfSensorId(int id);

    @Query("from MyDataClass where date> ?1 and date< ?2")
    public List<MyDataClass> getWithingdate(Date d1,Date d2);


}
