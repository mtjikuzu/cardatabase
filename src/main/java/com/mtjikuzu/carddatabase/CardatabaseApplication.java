package com.mtjikuzu.carddatabase;

import com.mtjikuzu.carddatabase.domain.Car;
import com.mtjikuzu.carddatabase.domain.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mtjikuzu.carddatabase.domain.Owner;
import com.mtjikuzu.carddatabase.domain.OwnerRepository;

import java.util.Arrays;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

        private static final Logger logger =

             LoggerFactory.getLogger
                 (CardatabaseApplication.class);

        private CarRepository repository;
        private OwnerRepository ownerRepository;
        public CardatabaseApplication(CarRepository repository, OwnerRepository ownerRepository ) {
            this.repository = repository;
            this.ownerRepository = ownerRepository;
        }


    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);

        logger.info("CardatabaseApplication started");
    }

    /**
     * @param args incoming main method arguments
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner("John", "Johnson");
        Owner owner2 = new Owner("Mary", "Robinson");
        ownerRepository.saveAll(Arrays.asList(owner1, owner2));
        repository.save(new Car("Ford", "Mustang", "Red", "ADF-1211", 2021, 59000, owner1));
        repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019,29000, owner2));
        repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, owner2));

        // Fetch all cars and log to console
        for (Car car : repository.findAll()) {
            logger.info("Brand: {}, Model: {}", car.getBrand(), car.getModel());
        }

    }

    public OwnerRepository getOwnerRepository() {
        return ownerRepository;
    }

    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }
}
