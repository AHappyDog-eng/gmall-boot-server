package com.mogujie.gmallprovider8001.controller;

import com.alibaba.fastjson.JSON;
import com.mogujie.gmallapi.pojo.Test.*;
import com.mogujie.gmallapi.pojo.multidata.*;
import com.mogujie.gmallprovider8001.service.TestMsgDaoImpl;
import org.apache.ibatis.io.ResolverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author WN
 * @date 2020/7/9 15:36
 */
@Controller
public class TestController {
    @Autowired
    private TestMsgDaoImpl testMsg;

    @RequestMapping("/test")
    @ResponseBody
    public String msg(){
        return "test";
    }

    @RequestMapping("/getban")
    @ResponseBody
    public Test testGet() {
        Test test = new Test();
        test.setUserName("zhangsan");
        test.setUserAge("12");
        Banners banners = new Banners("3", "15");
        Banners banners1 = new Banners("3", "15");
        Banners banners2 = new Banners("3", "15");
        Commonands commonands = new Commonands("2", "15");
        Commonands commonands1 = new Commonands("2", "15");
        Commonands commonands2 = new Commonands("2", "15");
        List<Banners> bannersList = new ArrayList<Banners>();
        List<Commonands> commonandsList = new ArrayList<Commonands>();
        bannersList.add(banners);
        bannersList.add(banners1);
        bannersList.add(banners2);
        commonandsList.add(commonands);
        commonandsList.add(commonands1);
        commonandsList.add(commonands2);
        test.setShowBanners(bannersList);
        test.setShowCommonands(commonandsList);
        return test;
    }


    @RequestMapping("getab")
    @ResponseBody
    public TestA getTestA() throws ExecutionException, InterruptedException {
        TestA testA = testMsg.getTestA(1);
        return testA;
    }
    @RequestMapping("getabc")
    @ResponseBody
    public List<TestC> getTestAbc() throws ExecutionException, InterruptedException {
        List<TestC> testABC = testMsg.getTestABC(1);
        return testABC;
    }
}
