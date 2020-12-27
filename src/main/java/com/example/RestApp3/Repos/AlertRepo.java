package com.example.RestApp3.Repos;

import com.example.RestApp3.Models.Alert;
import com.example.RestApp3.Models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlertRepo extends JpaRepository<Alert,Long> {
    @Query("from Alert where sensorId= ?1 order by timestamp")
    public List<Alert> getSignalsOfSensorId(long id);
}
