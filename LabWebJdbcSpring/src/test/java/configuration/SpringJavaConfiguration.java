package configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration							//<context:annotation-config />
@ComponentScan(basePackages={"model"})	//<context:component-scan base-package="model" />
public class SpringJavaConfiguration {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dmds = new DriverManagerDataSource();
		dmds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dmds.setUrl("jdbc:sqlserver://localhost:1433;database=java");
		dmds.setUsername("sa");
		dmds.setPassword("passw0rd");
		
		return dmds;
	}
}
