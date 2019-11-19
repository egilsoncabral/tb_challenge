package com.tbproject.challenge.config;


import com.tbproject.challenge.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = VehicleRepository.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(VehicleRepository vehicleRepository) {
        return strings -> {
            vehicleRepository.deleteAll();
        };
    }
}
