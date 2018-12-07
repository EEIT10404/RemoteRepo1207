package model.dao;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.ProductBean;
import model.ProductDAO;

public class ProductDAOXmlTest {
	private static ApplicationContext context;
	@BeforeClass
	public static void beforeClass() {
		context = new ClassPathXmlApplicationContext("beans.config.xml");
	}
	private ProductDAO productDao;
	@Before
	public void before() {
		productDao = (ProductDAO) context.getBean("productDAOJdbc");
	}
	
	@Test
	public void testFindByPrimaryKey() {
		ProductBean select = productDao.findByPrimaryKey(1);
		Assert.assertNotNull(select);
		Assert.assertEquals(1, select.getId());
	}
	@Test
	public void testFindAll() {
		List<ProductBean> selects = productDao.findAll();
		Assert.assertNotNull(selects);
		Assert.assertTrue(selects.size()>1);
	}

	@AfterClass
	public static void afterClass() {
		((ConfigurableApplicationContext) context).close();
	}
}
