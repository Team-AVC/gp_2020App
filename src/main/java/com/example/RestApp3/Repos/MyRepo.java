package com.example.RestApp3.Repos;

import com.example.RestApp3.Models.MyDataClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MyRepo extends JpaRepository<MyDataClass,Integer> {

    @Query("from MyDataClass where value>?1 and value<?2 order by name")
    public List<MyDataClass> getInRange(int lower,int higher);

    @Query("from MyDataClass where value<?1 or value>?2 order by name")
    public List<MyDataClass> getOutRange(int lower,int higher);


}
