package com.github.knightliao.test.test.h2.config;

import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import com.github.knightliao.test.h2.config.ConfigParser;
import com.github.knightliao.test.h2.config.InitDbConfig;

/**
 * @author knightliao
 * @date 2016/12/9 18:41
 */
public class ConfigParserTestCase {

    @Test
    public void test() {

        URL url = ConfigParserTestCase.class.getClassLoader().getResource("jutf-h2.xml");

        try {

            InitDbConfig initDbConfig = ConfigParser.parse(url.openStream());

            System.out.println(initDbConfig.toString());

        } catch (Exception e) {

            e.printStackTrace();

            Assert.assertTrue(false);
        }
    }
}
