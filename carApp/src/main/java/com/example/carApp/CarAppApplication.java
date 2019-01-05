package com.example.carApp;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.carApp.domain.Car;
import com.example.carApp.domain.CarRepository;
import com.example.carApp.domain.Owner;
import com.example.carApp.domain.OwnerRepository;

@SpringBootApplication
public class CarAppApplication {
	

	@Autowired 
    private CarRepository repository;
	
	@Autowired 
    private OwnerRepository orepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CarAppApplication.class, args);
		
	}
	@Bean
    CommandLineRunner runner() {
      return args -> {
        // Add owner objects and save these to db
        Owner owner1 = new Owner("John" , "Johnson");
        Owner owner2 = new Owner("Mary" , "Robinson");
        Owner owner3 = new Owner("Maaaa" , "Rossss");
        Owner owner4 = new Owner("Madsf" , "Rdddson");
        Set<Owner> ownerA=new HashSet<>();
        Set<Owner> ownerB=new HashSet<>();
        ownerA.add(owner1);
        ownerA.add(owner3);
        ownerB.add(owner2);
        ownerB.add(owner4);


        orepository.save(owner1);
        orepository.save(owner2);
        orepository.save(owner3);
        orepository.save(owner4);

        // Add car object with link to owners and save these to db.
        Car car = new Car("Ford", "Mustang", "Red", 
            "ADF-1121", 2017, 59000, ownerA);
        repository.save(car);
        car = new Car("Nissan", "Leaf", "White",
            "SSJ-3002", 2014, 29000, ownerB);
        repository.save(car);
        car = new Car("Toyota", "Prius", "Silver",
            "KKO-0212", 2018, 39000, ownerA);
        repository.save(car);
      };
	} 


}

