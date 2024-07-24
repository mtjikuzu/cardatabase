package com.mtjikuzu.carddatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {

//    // Fetch cars by brand
//    @Query("select c from Car c where c.brand = ?1")
        List<Car> findByBrand(String brand);
//
//    // Fetch cars by color
        List<Car> findByColor(String color);
//
//    // Fetch cars by year
        List<Car> findByModelYear(int modelYear);

}
