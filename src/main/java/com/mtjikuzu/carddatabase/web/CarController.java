package com.mtjikuzu.carddatabase.web;

import com.mtjikuzu.carddatabase.domain.Car;
import com.mtjikuzu.carddatabase.domain.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private final CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cars")
    public Iterable<Car> getCars() {
        return repository.findAll();
    }
}
