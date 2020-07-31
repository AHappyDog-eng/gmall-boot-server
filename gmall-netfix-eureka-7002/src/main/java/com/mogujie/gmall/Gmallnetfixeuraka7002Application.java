package com.mogujie.gmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author WN
 * @date 2020/7/9 12:16
 */
@SpringBootApplication
@EnableEurekaServer
public class Gmallnetfixeuraka7002Application {
    public static void main(String[] args) {
        SpringApplication.run(Gmallnetfixeuraka7002Application.class,args);
    }
}
