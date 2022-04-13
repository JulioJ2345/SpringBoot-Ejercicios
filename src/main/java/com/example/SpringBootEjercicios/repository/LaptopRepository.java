package com.example.SpringBootEjercicios.repository;

import com.example.SpringBootEjercicios.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface LaptopRepository extends JpaRepository<Laptop, Long> {
}
