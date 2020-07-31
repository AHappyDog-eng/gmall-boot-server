package com.mogujie.gmallconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author WN
 * @date 2020/7/9 12:27
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.mogujie.gmallapi.service")
public class Gmallconsumefeign80Application {
    public static void main(String[] args) {
        SpringApplication.run(Gmallconsumefeign80Application.class,args);
    }
}
