
#### mockito Test 

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