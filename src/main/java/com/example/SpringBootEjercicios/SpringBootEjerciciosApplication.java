package com.example.SpringBootEjercicios;

import com.example.SpringBootEjercicios.entity.Laptop;
import com.example.SpringBootEjercicios.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootEjerciciosApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootEjerciciosApplication.class, args);

		LaptopRepository laptopRepository = (LaptopRepository) context.getBean(LaptopRepository.class);

		Laptop ordenador1 = new Laptop(null, "Asus", "Sin sistema operativo", 8, 512, 2.30, 799.99, "Negro",true);
		Laptop ordenador2 = new Laptop(null, "Lenovo", "Windows", 8, 256, 1.70, 329.99, "Blanco",false);
		Laptop ordenador3 = new Laptop(null, "Apple", "macOs", 8, 512, 1.29, 1245.99, "Blanco",true);

		laptopRepository.save(ordenador1);
		laptopRepository.save(ordenador2);
		laptopRepository.save(ordenador3);
	}

}



