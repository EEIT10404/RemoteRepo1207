package model;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerServiceXmlTest {
	
	private static ApplicationContext context;
	@BeforeClass
	public static void beforeClass() {
		context = new ClassPathXmlApplicationContext("beans.config.xml");
	}
	
	private CustomerService customerService;
	@Before
	public void before() {
		customerService = (CustomerService) context.getBean("customerService");
	}

	@Test
	public void testLogin() {
		CustomerBean alex = customerService.login("Alex", "A");
		Assert.assertNotNull(alex);
		
		CustomerBean login = customerService.login("Alex", "AAA");
		Assert.assertNull(login);
	}
	
	@Test
	public void testChangePassword() {
		boolean change = customerService.changePassword("Ellen", "EEE", "EEE");
		Assert.assertTrue(change);
	}
	
	@AfterClass
	public static void afterClass() {
		((ConfigurableApplicationContext) context).close();
	}
	
	//anchor so handsome
}
