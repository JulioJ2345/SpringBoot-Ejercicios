package com.example.SpringBootEjercicios.controller;


import com.example.SpringBootEjercicios.entity.Laptop;
import com.example.SpringBootEjercicios.repository.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    @GetMapping("/api/laptops")
        public List<Laptop> findAll(){
            return laptopRepository.findAll();
        }

    @PostMapping("/api/laptops")
        public ResponseEntity<Laptop> create(@RequestBody Laptop laptop){
            if(laptop.getId() != null){
                return ResponseEntity.badRequest().build();
            }

            Laptop resultado = laptopRepository.save(laptop);
            return ResponseEntity.ok(resultado);

    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> findOneById(@PathVariable Long id){
         Optional<Laptop> laptopOpt = laptopRepository.findById(id);
         if(laptopOpt.isPresent()){
                return ResponseEntity.ok(laptopOpt.get());
         }else{
                return ResponseEntity.notFound().build();
         }

    }

    @PutMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
            if(laptop.getId() == null){
                return ResponseEntity.badRequest().build();
            }if(!laptopRepository.existsById(laptop.getId())){
                return ResponseEntity.notFound().build();
            }
            Laptop resultado = laptopRepository.save(laptop);
            return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> delete(@PathVariable Long id){
            if(!laptopRepository.existsById(id)){
                return ResponseEntity.notFound().build();
            }
            laptopRepository.deleteById(id);
            return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }


}
