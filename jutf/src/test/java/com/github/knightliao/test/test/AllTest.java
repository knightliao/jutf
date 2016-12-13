package com.github.knightliao.test.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.github.knightliao.test.test.log.logback.LogbackCapturingAppenderTest;
import com.github.knightliao.test.test.mockito.DemoServiceTest;
import com.github.knightliao.test.test.support.utils.DomTest;

/**
 * Created by knightliao on 16/6/6.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({DomTest.class, LogbackCapturingAppenderTest.class, DemoServiceTest.class})
public class AllTest {

}


