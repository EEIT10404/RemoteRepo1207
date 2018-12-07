package model.dao;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import model.CustomerBean;
import model.CustomerDAO;

public class CustomerDAOJavaConfigTest {
	private static ApplicationContext context;
	@BeforeClass
	public static void beforeClass() {
		context = new AnnotationConfigApplicationContext(
				configuration.SpringJavaConfiguration.class);
	}
	
	private CustomerDAO customerDao;
	@Before
	public void before() {
		customerDao = (CustomerDAO) context.getBean("customerDAOJdbc");
	}
	@Test
	public void testFindByPrimaryKey() {
		CustomerBean select = customerDao.findByPrimaryKey("Babe");
		Assert.assertNotNull(select);
		Assert.assertEquals("Babe", select.getCustid());
	}

	@Test
	public void testUpdate() {
		boolean update = customerDao.update(
				"EEE".getBytes(), "ellen@iii.org.tw", new java.util.Date(0), "Ellen");
		Assert.assertTrue(update);
	}
	
	@AfterClass
	public static void afterClass() {
		((ConfigurableApplicationContext) context).close();
	}
}
