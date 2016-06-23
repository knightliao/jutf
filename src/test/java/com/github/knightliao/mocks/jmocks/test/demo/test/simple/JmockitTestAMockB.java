package com.github.knightliao.mocks.jmocks.test.demo.test.simple;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.knightliao.mocks.jmocks.test.demo.mocks.IBMocks;
import com.github.knightliao.mocks.jmocks.test.demo.service.IB;
import com.github.knightliao.mocks.jmocks.test.demo.service.impl.A;
import com.github.knightliao.mocks.jmocks.test.demo.test.MyAbstractBaseTest;

/**
 * 对A进行测试，mock b
 * <p/>
 * Created by knightliao on 16/6/6.
 */
public class JmockitTestAMockB extends MyAbstractBaseTest {

    @Autowired
    A a;

    @Autowired
    IB ib;

    /**
     * Mock ib, 预期1
     */
    @Test
    public void testMockit1() {

        IBMocks.getMocks(ib);

        String data = a.method();

        Assert.assertEquals(data, "IBMocks.mocks1");
    }

    /**
     * Mock ib, 预期2
     */
    @Test
    public void testMockit2() {

        IBMocks.getMocks2(ib);

        String data = a.method();

        Assert.assertEquals(data, "IBMocks.mocks2");
    }

    /*
    * 无mock
     */
    @Test
    public void test() {

        String data = a.method();

        Assert.assertEquals(data, "b=1");
    }
}
