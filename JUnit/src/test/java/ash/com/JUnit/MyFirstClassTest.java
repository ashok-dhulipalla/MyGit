package ash.com.JUnit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyFirstClassTest {

	@BeforeClass
	public static void beforeClass()
	{
		System.out.println("beforeClass");
	}
	@AfterClass
	public static void afterClass()
	{
		System.out.println("afterClass");
	}
	@Before
	public void before()
	{
		System.out.println("before");
	}
	@After
	public void after()
	{
		System.out.println("after");
	}
    @Test(timeout = 1)
    public void myFirstMethod(){	
    	for(int i= 0; i < 99;i++)
    	{
    		System.out.println("test case 1");
    	}
    	System.out.println("test case 1");
        String str= "JUnit is working fine";
        assertEquals("JUnit is working fine",str);
    }
}
