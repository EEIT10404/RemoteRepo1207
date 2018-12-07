package model;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductServiceJavaConfigTest {
	private static ApplicationContext context;
	@BeforeClass
	public static void beforeClass() {
		context = new AnnotationConfigApplicationContext(
				configuration.SpringJavaConfiguration.class);
	}
	private ProductService productService;
	@Before
	public void before() {
		productService = (ProductService) context.getBean("productService");
	}
	
	@Test
	public void testSelect() {
		List<ProductBean> beans = productService.select(null);
		Assert.assertNotNull(beans);
		Assert.assertTrue(beans.size()>1);
	}
	
	@AfterClass
	public static void afterClass() {
		((ConfigurableApplicationContext) context).close();
	}
//<<<<<<< HEAD
//	
//	//anchor is very very handsome !!!
//=======
//>>>>>>> branch 'master' of https://github.com/EEIT10404/RemoteRepo1207.git
}
