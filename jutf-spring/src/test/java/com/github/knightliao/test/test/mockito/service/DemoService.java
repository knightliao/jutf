package com.github.knightliao.test.test.mockito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.knightliao.test.test.mockito.dao.DemoDao;
import com.github.knightliao.test.test.mockito.entity.Demo;

/**
 * @author zhugongrui
 * @date 2016年6月29日下午5:57:59
 */
@Service
public class DemoService {

    @Autowired
    UsedService usedService;

    @Autowired
    DemoDao demoDao;

    public String echo(String str) {
        Demo demo = new Demo();
        demo.setId(1L);
        demo.setDemoValue("demo");
        demoDao.updateByPrimaryKeySelective(demo);
        return usedService.echo("hello");
    }

}
