package com.mogujie.gmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ApplicationContext;

/**
 * @author WN
 * @date 2020/7/9 11:48
 */
@SpringBootApplication
@EnableEurekaServer
public class Gmallnetfixeureka7001Application {
    public static void main(String[] args) {
        SpringApplication.run(Gmallnetfixeureka7001Application.class,args);
    }
}
