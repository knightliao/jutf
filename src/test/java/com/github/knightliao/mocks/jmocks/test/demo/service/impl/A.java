package com.github.knightliao.mocks.jmocks.test.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.knightliao.mocks.jmocks.test.demo.service.IA;

@Service
public class A implements IA {

    @Autowired
    B b;

    public String method() {
        String data = b.method();
        System.out.println(data);
        return data;
    }
}  