package edu.aspire.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;


/*@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(basePackages = "edu.aspire.daos")*/

//The above three annotations together is same as @SpringBootApplication.
@SpringBootApplication(scanBasePackages="edu.aspire.daos")
public class SpringJdbcConfig {
	/*@Bean
	public DataSource dataSource() { //auto configured by spring boot
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("system");
		bds.setPassword("manager");
		bds.setInitialSize(10);
		bds.setMaxActive(15);
		return bds;
	}*/

	/*@Bean
	public JdbcTemplate jdbcTemplate(DataSource ds) { //auto configured by spring boot
		return new JdbcTemplate(ds);
	}*/
	
	/*@Bean(name = "empdao" )
	public EmployeeDao empDao(){ //auto discovered by spring.
		return new EmployeeDaoImpl();
	}*/
}
