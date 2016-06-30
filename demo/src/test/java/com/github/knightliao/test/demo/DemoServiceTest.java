package com.github.knightliao.test.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.github.knightliao.test.datasource.SqlConfig;
import com.github.knightliao.test.datasource.SqlConfig.Database;
import com.github.knightliao.test.demo.dao.DemoDao;
import com.github.knightliao.test.demo.entity.Demo;
import com.github.knightliao.test.demo.service.DemoService;
import com.github.knightliao.test.demo.service.UsedService;
import com.github.knightliao.test.junit.tests.AbstractTransactionalTest;

/**
 * @author zhugongrui
 * @date 2016年6月29日下午6:01:20
 */
@ContextConfiguration(locations = "classpath:spring-test.xml")
public class DemoServiceTest extends AbstractTransactionalTest {
	@InjectMocks
	@Autowired
	DemoService demoService;
	
	@Mock
	UsedService usedService;
	
	@Autowired
	DemoDao demoDao;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		Mockito.when(usedService.echo("hello")).thenReturn("world");
	}
	
	/**
	 * 如不指定database，默认是mysql数据源
	 * demo中没有使用数据库，此处的SqlConfig主要是为了说明用法
	 * 
	 * 此方法执行前会执行demo.sql,执行后回滚 
	 */
	@Test
	@SqlConfig(database = Database.H2, sqlFiles = { "classpath:sql/demo_data.sql" })
	public void testEcho() {
		String result = demoService.echo("hello");
		Demo demo = demoDao.selectByPrimaryKey(1L);
		Assert.assertEquals("world", result);
		Assert.assertEquals("demo", demo.getDemoValue());
	}
}
