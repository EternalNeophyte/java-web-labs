
package edu.alexandrov.labs.rmi.server.src.main.java;

import edu.alexandrov.labs.service.TimeTableManagerService;
import edu.alexandrov.labs.service.impl.TimeTableManagerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.remoting.rmi.RmiServiceExporter;
/*

@SpringBootApplication

@EnableJpaRepositories(basePackages = "edu.alexandrov.labs.repository")
@ComponentScan(basePackages = {
		"edu.alexandrov.labs.service",
		"edu.alexandrov.labs.repository",
		"edu.alexandrov.labs.mapper"})
@EntityScan(basePackages = "edu.alexandrov.labs.entity")


public class ServerApplication {

	@Bean
	TimeTableManagerService timeTableManagerService() {
		return new TimeTableManagerServiceImpl();
	}

	RmiServiceExporter exporter(TimeTableManagerService implementation) {

		Class<TimeTableManagerService> serviceInterface = TimeTableManagerService.class;
		RmiServiceExporter exporter = new RmiServiceExporter();
		exporter.setServiceInterface(serviceInterface);
		exporter.setService(implementation);
		exporter.setServiceName(serviceInterface.getSimpleName());
		exporter.setRegistryPort(1099);
		return exporter;
	}

	public static void main(String[] args) {

		SpringApplication.run(ServerApplication.class, args);
	}
}
 */