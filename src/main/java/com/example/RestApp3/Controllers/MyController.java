package com.example.RestApp3.Controllers;

import com.example.RestApp3.Models.MyDataClass;
import com.example.RestApp3.Models.MyPair;
import com.example.RestApp3.Repos.MyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class MyController {

    @Autowired
    MyRepo dataRepo;

    @RequestMapping("/")
    public String func1(){

        return "from index func";
    }

    @RequestMapping("port/data")
    public List<MyDataClass> func2(){

        return dataRepo.findAll();
    }

    @RequestMapping("port/data/outofrange")
    public List<MyDataClass> func3(MyPair pair){
        int lower=pair.getLower();
        int higher=pair.getHigher();

        return dataRepo.getInRange(lower,higher);
    }

    @RequestMapping("port/data/{sensorid}")
    public List<MyDataClass> func4(@PathVariable("sensorid")int id){

        return dataRepo.getSignalsOfSensor(id);
    }


    @RequestMapping("port/data/postdataparas")
    public String func5(MyDataClass mydata){

        dataRepo.save(mydata);
        return "Done save";
    }

    @RequestMapping("port/data/postdatabody")
    public String func6(@RequestBody MyDataClass data){
        dataRepo.save(data);
        return "Done save";

    }


    @RequestMapping("port/data/getwithingdate")
    public List<MyDataClass> func7(){

        return null;
    }

}



