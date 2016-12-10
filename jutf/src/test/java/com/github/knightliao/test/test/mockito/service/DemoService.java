package com.github.knightliao.test.test.mockito.service;

import com.github.knightliao.test.test.mockito.service.impl.UsedServiceImpl;

/**
 * @author knightliao
 * @date 2016/12/10 12:05
 */
public class DemoService {

    private IUsedService iUsedService = new UsedServiceImpl();

    public String echo2(String str) {

        return iUsedService.echo(str);
    }

}
