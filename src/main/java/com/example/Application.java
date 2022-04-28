package com.example;

import com.example.entity.Laptop;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.repository.LaptopRepository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		ApplicationContext context = SpringApplication.run(Application.class,args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		  		//create the laptops and

		  		Laptop laptop1 = new Laptop("cpu","intel",8);
		  		Laptop laptop2 = new Laptop("cpu","intel",4);
		  		Laptop laptop3 = new Laptop("cpu","intel",16);
		  		laptopRepository.save(laptop1);
		  		laptopRepository.save(laptop2);
		  		laptopRepository.save(laptop3);
		/**
		 * 	ApplicationContext context = SpringApplication.run(Application.class, args);
		 * 		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);
		 *
		 * 		//create the laptops and
		 *
		 * 		Laptop laptop1 = new Laptop("cpu","intel",8);
		 * 		Laptop laptop2 = new Laptop("cpu","intel",4);
		 * 		Laptop laptop3 = new Laptop("cpu","intel",16);
		 * 		laptopRepository.save(laptop1);
		 * 		laptopRepository.save(laptop2);
		 * 		laptopRepository.save(laptop3);
		 */
	}

}
