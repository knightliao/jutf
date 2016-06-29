package com.github.knightliao.mocks.jmocks.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.github.knightliao.mocks.jmocks.test.demo.simple.JmockitTestAMockB;
import com.github.knightliao.mocks.jmocks.test.demo.simple.JmockitTestAMockC;

/**
 * Created by knightliao on 16/6/6.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({JmockitTestAMockB.class, JmockitTestAMockC.class})
public class AllTest {
}


