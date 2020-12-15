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
    public String mainFunc(){

        return "for main";
    }

    @RequestMapping("/getdata/{mid}")
    public MyDataClass func2(@PathVariable("mid")int id){

        MyDataClass data=(MyDataClass) dataRepo.findById(id).orElse(new MyDataClass());
        return data;
    }

    @RequestMapping("/getdata")
    public List<MyDataClass> func3(){

        return  dataRepo.findAll();
    }


    @RequestMapping(path="/postdata",consumes = "application/json")
    public String func4(@RequestBody MyDataClass dta){
        dataRepo.save(dta);
        return "SaveDone";
    }

    @RequestMapping("/postdataparas")
    public String func5(MyDataClass mydata){

        dataRepo.save(mydata);

        return "Done paras";
    }

    @RequestMapping("/getdata/inrange")
    public List<MyDataClass> func6(MyPair pair){
        int lower=pair.getLower();
        int higher=pair.getHigher();
        return dataRepo.getInRange(lower,higher);
    }

    @RequestMapping("/getdata/outrange")
    public List<MyDataClass> func7(MyPair pair){
        int lower=pair.getLower();
        int higher=pair.getHigher();
        return dataRepo.getOutRange(lower,higher);
    }


}



