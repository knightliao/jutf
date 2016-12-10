package com.github.knightliao.test.test.mockito.service.impl;

import com.github.knightliao.test.test.mockito.service.IUsedService;

/**
 *
 */
public class UsedServiceImpl implements IUsedService {

    @Override
    public String echo(String str) {
        return str;
    }
}
