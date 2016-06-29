
package com.github.knightliao.test.junit.tests;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.knightliao.test.junit.listener.UnitTestDependencyInjectionTestExecutionListener;
import com.github.knightliao.test.junit.listener.UnitTestTransactionalTestExecutionListener;

/**
 * @author zhugongrui
 * @date 2016年6月13日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(listeners = {ServletTestExecutionListener.class,
        DirtiesContextBeforeModesTestExecutionListener.class,
        UnitTestDependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
        UnitTestTransactionalTestExecutionListener.class,
        SqlScriptsTestExecutionListener.class}, inheritListeners = false)
@Transactional
@Rollback
public abstract class AbstractTransactionalTest extends AbstractJUnit4SpringContextTests {
}
