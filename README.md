jutf 
=======

[![Apache License 2](https://img.shields.io/badge/license-ASF2-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0.txt)
[![Build Status](https://travis-ci.org/knightliao/jutf.svg?branch=master)](https://travis-ci.org/knightliao/jutf) 
[![Coverage Status](https://coveralls.io/repos/github/knightliao/jutf/badge.svg?branch=master)](https://coveralls.io/github/knightliao/jutf?branch=master) 
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.knightliao.test/jutf/badge.svg?style=plastic)](https://maven-badges.herokuapp.com/maven-central/com.github.knightliao.test/jutf) 
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.knightliao.test/jutf-spring/badge.svg?style=plastic)](https://maven-badges.herokuapp.com/maven-central/com.github.knightliao.test/jutf-spring)

Java Unit Test Framework (Warp H2/Mockito/jmockit tools to make java application better) 
 
## Func

- jutf-Spring(spring dependency version)
    - Use mockito/jmockit to mock interface 
    - H2/Mysql Test db utils
- jutf(spring free dependency version)
    - Use mockito/jmockit to mock interface 
    - Utils to mock get/set/construct/tostring
    - H2 Memory Test db utils

## Quick Start

### jutf

#### H2 Test

XML Configuration: 

    <configuration>
        <initialize-database>
            <schema>sql/schema/demo_schema.sql</schema>
        </initialize-database>
        <initialize-data>
            <data>sql/goldendata/demo_data.sql</data>
        </initialize-data>
    </configuration>

H2 Test Code:

    public class H2BaseTestCaseTest extends H2BaseTestCase {
    
        @Test
        public void foo() {
    
            try {
    
                String query = "select * from test.t_demo";
                List<Map<String, Object>> listOfMaps = executeSql(query);
    
                System.out.println(new Gson().toJson(listOfMaps));
    
                Assert.assertEquals(listOfMaps.size(), 2);
    
            } catch (SQLException se) {
    
                Assert.assertTrue(false);
                throw new RuntimeException("Couldn't query the database.", se);
    
            }
    
        }
    }

#### get/set/construct/tostring Test

    @Test
    public void test() {
        TestUtils.testAllClassUnderPackage("com.github.knightliao.test");
    }
    
#### mockito case 

    public class DemoServiceTest {
    
        @InjectMocks
        private DemoService demoService = new DemoService();
    
        @Spy
        private IUsedService usedService = new UsedServiceImpl();
    
        @Before
        public void setUp() {
    
            MockitoAnnotations.initMocks(this);
            Mockito.when(usedService.echo("hello")).thenReturn("world");
    
        }
    
        @Test
        public void testEcho() {
    
            String result = demoService.echo2("hello");
            Assert.assertEquals("world", result);
    
            result = demoService.echo2("hello world");
            Assert.assertEquals("hello world", result);
        }
    }

### jutf-Spring

    @ContextConfiguration(locations = "classpath:spring-test.xml")
    public class BaseTest extends AbstractTransactionalTest {
        @InjectMocks
        @Autowired
        DemoService demoService;
    
        @Mock
        UsedService usedService;
    
        @Autowired
        DemoDao demoDao;
    
        @Before
        public void setUp() {
            MockitoAnnotations.initMocks(this);
            Mockito.when(usedService.echo("hello")).thenReturn("world");
        }
    
        /**
         * 如不指定database，默认是mysql数据源
         * demo中没有使用数据库，此处的SqlConfig主要是为了说明用法
         * <p/>
         * 此方法执行前会执行demo.sql,执行后回滚
         */
        @Test
        @SqlConfig(database = Database.H2, sqlFiles = {"classpath:sql/goldendata/demo_data.sql"})
        public void testEcho() {
            String result = demoService.echo("hello");
            Demo demo = demoDao.selectByPrimaryKey(1L);
            Assert.assertEquals("world", result);
            Assert.assertEquals("demo", demo.getDemoValue());
        }
    }

## Maven

### jutf

    <dependency>
        <groupId>com.github.knightliao.test</groupId>
        <artifactId>jutf</artifactId>
        <version>1.0.2</version>
    </dependency>
    
### jutf-Spring

    <dependency>
        <groupId>com.github.knightliao.test</groupId>
        <artifactId>jutf-spring</artifactId>
        <version>1.0.2</version>
    </dependency>
    
## 推荐
    
- 有态度无广告的搜索引擎: https://www.sov5.com
- 微读 - 高品质阅读: http://www.100weidu.com
- Python中国社区: http://www.python88.com
- Disconf - 分布式配置管理平台: http://github.com/knightliao/disconf
- CanalX - 基于 `Canal` 的数据感知服务框架: http://github.com/knightliao/canalX
- jutf - Java Unit Test Framework: https://github.com/knightliao/jutf
- pfrock - A plugin-based server for running fake HTTP services (especially SOA service): https://github.com/knightliao/pfrock