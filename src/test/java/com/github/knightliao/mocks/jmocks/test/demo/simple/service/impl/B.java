package com.github.knightliao.mocks.jmocks.test.demo.simple.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.knightliao.mocks.jmocks.test.demo.simple.service.IB;
import com.github.knightliao.mocks.jmocks.test.demo.simple.service.IC;

/**
 * Created by knightliao on 16/6/6.
 */
@Service
public class B implements IB {

    @Autowired
    IC c;

    public String method() {

        String data = "b=" + c.method();

        return data;
    }
}
