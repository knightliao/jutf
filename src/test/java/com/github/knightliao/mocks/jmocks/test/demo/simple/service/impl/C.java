package com.github.knightliao.mocks.jmocks.test.demo.simple.service.impl;

import org.springframework.stereotype.Service;

import com.github.knightliao.mocks.jmocks.test.demo.simple.service.IC;

/**
 * Created by knightliao on 16/6/6.
 */
@Service
public class C implements IC {

    public Integer method() {
        return 1;
    }
}
