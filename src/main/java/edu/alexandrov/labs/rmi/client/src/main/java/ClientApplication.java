
package edu.alexandrov.labs.rmi.client.src.main.java;

import edu.alexandrov.labs.service.TimeTableManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
/*
@SpringBootApplication

@EnableJpaRepositories(basePackages = "edu.alexandrov.labs.repository")
@ComponentScan(basePackages = {
		"edu.alexandrov.labs.service",
		"edu.alexandrov.labs.repository",
		"edu.alexandrov.labs.mapper"})
@EntityScan(basePackages = "edu.alexandrov.labs.entity")


public class ClientApplication {

	@Bean
	RmiProxyFactoryBean service() {

		RmiProxyFactoryBean rmiProxyFactory = new RmiProxyFactoryBean();
		rmiProxyFactory.setServiceUrl("rmi://localhost:1099/TimeTableManagerService");
		rmiProxyFactory.setServiceInterface(TimeTableManagerService.class);
		return rmiProxyFactory;
	}

	public static void main(String[] args)  {

		TimeTableManagerService service =
				SpringApplication.run(ClientApplication.class, args).getBean(TimeTableManagerService.class);
		System.out.println(service.findByIsWeekEven(true).hashCode());
	}
}
*/

