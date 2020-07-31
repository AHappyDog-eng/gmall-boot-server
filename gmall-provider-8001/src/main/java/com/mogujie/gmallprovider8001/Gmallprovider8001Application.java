package com.mogujie.gmallprovider8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author WN
 * @date 2020/7/9 15:02
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60*60*24)
public class Gmallprovider8001Application {
    public static void main(String[] args) {
        SpringApplication.run(Gmallprovider8001Application.class,args);
    }
}
