package com.github.knightliao.mocks.jmocks.test.demo.simple.mocks;

import com.github.knightliao.mocks.jmocks.test.demo.simple.service.IC;

import mockit.Expectations;

/**
 * Created by knightliao on 16/6/6.
 */
public class ICMocks {

    /**
     * @param ic
     */
    public static void getMocks(final IC ic) {

        new Expectations(ic) {
            {
                ic.method();
                //可以对输入进行解析,不同的输入不同的返回.
                result = Integer.valueOf(10);
            }
        };
    }

    /**
     * @param ic
     */
    public static void getMocks2(final IC ic) {

        new Expectations(ic) {
            {
                ic.method();
                //可以对输入进行解析,不同的输入不同的返回.
                result = Integer.valueOf(20);
            }
        };
    }
}
