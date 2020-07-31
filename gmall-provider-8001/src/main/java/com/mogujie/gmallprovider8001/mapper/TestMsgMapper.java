package com.mogujie.gmallprovider8001.mapper;

import com.mogujie.gmallapi.pojo.Test.TestA;
import com.mogujie.gmallapi.pojo.Test.TestB;
import com.mogujie.gmallapi.pojo.Test.TestC;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author WN
 * @date 2020/7/10 11:29
 */
@Mapper
@Repository
public interface TestMsgMapper {
    /**
     * testA
     */
    TestA getTestA(Integer testAId);
    TestB getTestB(Integer testabcid);
    TestA getTestAByResult(Integer testAId);
    List<TestC> getTestABC(Integer testAId);
}
