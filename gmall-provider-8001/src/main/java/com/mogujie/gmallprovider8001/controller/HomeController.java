package com.mogujie.gmallprovider8001.controller;

import com.mogujie.gmallapi.pojo.multidata.MultiData;
import com.mogujie.gmallprovider8001.service.MutilDataImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WN
 * @date 2020/7/12 17:42
 */
@RestController
public class HomeController {
    @Autowired
    private MutilDataImpl data;
    @RequestMapping("/mutildata")
    public MultiData getMutilData() {
        System.out.println("mutildata Controller-------------------------");
        return data.getMultiData();
    }
    @RequestMapping("/home/feaultview")
    public String getFeaultView(){
        return "hello world !";
    }
}
