package com.mogujie.gmallprovider8001.service;

import com.mogujie.gmallapi.pojo.Test.TestA;
import com.mogujie.gmallapi.pojo.Test.TestB;
import com.mogujie.gmallapi.pojo.Test.TestC;
import com.mogujie.gmallprovider8001.mapper.TestMsgMapper;
import com.mogujie.gmallprovider8001.utils.ThreadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author WN
 * @date 2020/7/10 11:29
 */
@Service
public class TestMsgDaoImpl implements TestMsgDao {
    @Autowired
    private TestMsgMapper testMsgMapper;

    @Autowired
    private ThreadUtils threadUtils;
    public TestA getTestA(Integer testAId) throws ExecutionException, InterruptedException {
        TestA testA = testMsgMapper.getTestA(1);
        return testA;
    }


    public TestB getTestB(Integer testabcid) {
        TestB testB = testMsgMapper.getTestB(1);
        return testB;
    }

    public TestA getTestAByResult(Integer testAId) {
        TestA testAByResult = testMsgMapper.getTestAByResult(1);
        return testAByResult;
    }

    public List<TestC> getTestABC(Integer testAId) {
        return testMsgMapper.getTestABC(1);
    }
}
