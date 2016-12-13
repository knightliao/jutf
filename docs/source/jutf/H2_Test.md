
## H2 Test

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