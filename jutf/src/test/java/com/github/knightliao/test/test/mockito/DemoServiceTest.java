package com.github.knightliao.test.test.mockito;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.github.knightliao.test.test.mockito.service.DemoService;
import com.github.knightliao.test.test.mockito.service.IUsedService;
import com.github.knightliao.test.test.mockito.service.impl.UsedServiceImpl;

/**
 * http://stackoverflow.com/questions/17218694/mockito-calling-real-method
 */
public class DemoServiceTest {

    @InjectMocks
    private DemoService demoService = new DemoService();

    @Spy
    private IUsedService usedService = new UsedServiceImpl();

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        Mockito.when(usedService.echo("hello")).thenReturn("world");

    }

    @Test
    public void testEcho() {

        String result = demoService.echo2("hello");
        Assert.assertEquals("world", result);

        result = demoService.echo2("hello world");
        Assert.assertEquals("hello world", result);
    }
}
