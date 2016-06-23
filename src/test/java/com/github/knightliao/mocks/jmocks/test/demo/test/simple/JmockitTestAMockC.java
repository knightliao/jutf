package com.github.knightliao.mocks.jmocks.test.demo.test.simple;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.knightliao.mocks.jmocks.test.demo.mocks.ICMocks;
import com.github.knightliao.mocks.jmocks.test.demo.service.IA;
import com.github.knightliao.mocks.jmocks.test.demo.service.IC;
import com.github.knightliao.mocks.jmocks.test.demo.test.MyAbstractBaseTest;

/**
 * 对A进行测试，mock c
 * <p/>
 * Created by knightliao on 16/6/6.
 */
public class JmockitTestAMockC extends MyAbstractBaseTest {

    @Autowired
    IA a;

    @Autowired
    IC ic;

    /**
     * Mock ic, 预期1
     */
    @Test
    public void testMockit1() {

        ICMocks.getMocks(ic);

        String data = a.method();

        Assert.assertEquals(data, "b=10");
    }

    /**
     * Mock ic, 预期2
     */
    @Test
    public void testMockit2() {

        ICMocks.getMocks2(ic);

        String data = a.method();

        Assert.assertEquals(data, "b=20");
    }

    /**
     * no mock
     */
    @Test
    public void test() {

        String data = a.method();

        Assert.assertEquals(data, "b=1");
    }
}
