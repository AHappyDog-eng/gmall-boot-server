package com.mogujie.gmallprovider8001.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author WN
 * @date 2020/7/10 11:42
 */
@Component
public class ThreadUtils {
    public static ThreadPoolExecutor getThreadPool(){
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3,
                10,
                5000L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(110),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        return poolExecutor;
    }
}
