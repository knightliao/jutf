package com.github.knightliao.test.h2;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.zapodot.junit.db.EmbeddedDatabaseRule;

import com.github.knightliao.test.h2.config.ConfigParser;
import com.github.knightliao.test.h2.config.InitDbConfig;

/**
 * @author knightliao
 * @date 2016/12/9 16:17
 */

public abstract class H2BaseTestCase {

    protected Connection connection;

    protected String db2PropertiesFile = "jutf-h2.properties";
    protected static String db2XmlFile = "jutf-h2.xml";

    protected static InitDbConfig initDbConfig;

    static {

        URL url = H2BaseTestCase.class.getClassLoader().getResource(db2XmlFile);

        try {
            initDbConfig = ConfigParser.parse(url.openStream());

        } catch (Exception e) {
            System.err.println(e.toString());
            Assert.assertTrue(false);
        }
    }

    @Rule
    public EmbeddedDatabaseRule dbRule = EmbeddedDatabaseRule
            .builder()
            .withMode("MYSQL")
            .withInitialSql(initDbConfig.getTotalSchema() + initDbConfig.getTotalData())
            .build();

    @Before
    public void setup() {
        try {

            connection = DriverManager.getConnection(dbRule.getConnectionJdbcUrl());

        } catch (Exception e) {
            System.err.println(e.toString());
            Assert.assertTrue(false);
        }
    }

    public List<Map<String, Object>> executeSql(String sql) throws SQLException {

        try {

            QueryRunner queryRunner = new QueryRunner();

            return queryRunner.query(connection, sql, new MapListHandler());

        } finally {

            DbUtils.closeQuietly(connection);
        }
    }

}
