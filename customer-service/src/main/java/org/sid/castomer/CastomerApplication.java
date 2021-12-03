package org.sid.castomer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.sid.castomer.entities.Customer;
import org.sid.castomer.repositories.CustomerRepository;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CastomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CastomerApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
		restConfiguration.exposeIdsFor(Customer.class);
		return args -> {
			customerRepository.save(new Customer(null,"mehdi","elmehdi@gmail.com"));
			customerRepository.save(new Customer(null,"hamza","hamza@gmail.com"));
			customerRepository.save(new Customer(null,"ayoub","ayoub@gmail.com"));
			customerRepository.findAll().forEach(c->{
				System.out.println(c.toString());
			});
		};
	}

}
