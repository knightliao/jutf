Jutf [![Build Status](https://travis-ci.org/knightliao/jutf.svg?branch=master)](https://travis-ci.org/knightliao/jutf) [![Coverage Status](https://coveralls.io/repos/github/knightliao/jutf/badge.svg?branch=master)](https://coveralls.io/github/knightliao/jutf?branch=master)
=======

Java Unit Test Framework 
 
### 功能

- Jutf-Spring
    - Use mockito to mock interface 
    - Use H2/Mysql(配置选择) to mock db
- Jutf
    - Utils to mock get/set/construct/tostring

### Quick Start

#### Jutf-Spring

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

#### Jutf

    @Test
    public void test() {
        TestUtils.testAllClassUnderPackage("com.github.knightliao.test");
    }

### Maven

#### Jutf

    <dependency>
        <groupId>com.github.knightliao.test</groupId>
        <artifactId>jutf</artifactId>
        <version>1.0.2-SNAPSHOT</version>
    </dependency>
    
#### Jutf-Spring

    <dependency>
        <groupId>com.github.knightliao.test</groupId>
        <artifactId>jutf-spring</artifactId>
        <version>1.0.2-SNAPSHOT</version>
    </dependency>