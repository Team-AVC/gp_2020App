package com.example.RestApp3.Repos;

import com.example.RestApp3.Models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SensorRepo extends JpaRepository<Sensor,Long> {
    @Query("from Sensor where sensorId= ?1")
    public List<Sensor> getSignalsOfSensorId(long id);

}
