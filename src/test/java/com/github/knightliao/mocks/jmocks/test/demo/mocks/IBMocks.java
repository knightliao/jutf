package com.github.knightliao.mocks.jmocks.test.demo.mocks;

import com.github.knightliao.mocks.jmocks.test.demo.service.IB;

import mockit.Expectations;

/**
 * Created by knightliao on 16/6/6.
 */
public class IBMocks {

    /**
     * @param ib
     */
    public static void getMocks(final IB ib) {

        new Expectations(ib) {
            {
                ib.method();
                result = "IBMocks.mocks1";
            }
        };
    }

    /**
     * @param ib
     */
    public static void getMocks2(final IB ib) {

        new Expectations(ib) {
            {
                ib.method();
                result = "IBMocks.mocks2";
            }
        };
    }

}
