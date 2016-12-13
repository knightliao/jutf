
## H2 Test

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