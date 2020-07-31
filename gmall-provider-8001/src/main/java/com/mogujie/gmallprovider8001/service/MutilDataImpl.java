package com.mogujie.gmallprovider8001.service;

import com.mogujie.gmallapi.pojo.multidata.MultiData;
import com.mogujie.gmallprovider8001.mapper.MutilDataMapper;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author WN
 * @date 2020/7/12 17:00
 */
@Service
public class MutilDataImpl implements MutilDataDao {

    @Autowired
    private MutilDataMapper dataMapper;

    public MultiData getMultiData() {
        System.out.println("mutildata Controller-------------------------");
        MultiData multiData = dataMapper.getMultiData();
        System.out.println(multiData.toString());
        return multiData;
    }
}
