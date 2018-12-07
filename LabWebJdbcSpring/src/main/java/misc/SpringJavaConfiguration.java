package misc;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
@ComponentScan(basePackages={"model"})
public class SpringJavaConfiguration {
	@Bean
	public DataSource dataSource() {
		try {
			JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
			bean.setJndiName("java:comp/env/jdbc/xxx");
			bean.setProxyInterface(DataSource.class);
			bean.afterPropertiesSet();
			return (DataSource) bean.getObject();
		} catch (IllegalArgumentException | NamingException e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
}
