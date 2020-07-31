package com.mogujie.gmallprovider8001.service;

import com.mogujie.gmallapi.pojo.Test.TestA;
import com.mogujie.gmallapi.pojo.Test.TestB;
import com.mogujie.gmallapi.pojo.Test.TestC;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author WN
 * @date 2020/7/10 11:28
 */
public interface TestMsgDao {
    TestA getTestA(Integer testAId) throws ExecutionException, InterruptedException;
    TestB getTestB(Integer testabcid);
    TestA getTestAByResult(Integer testAId);
    List<TestC> getTestABC(Integer testAId);
}
