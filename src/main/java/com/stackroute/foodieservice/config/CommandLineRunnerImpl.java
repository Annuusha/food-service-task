package com.stackroute.foodieservice.config;

import com.stackroute.foodieservice.domain.Restaurant;
import com.stackroute.foodieservice.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
private RestaurantRepository restaurantRepository;


    @Value("${id2}")
    int id;
    @Value("${restaurantName2}")
    String restaurantName;
    @Value(("${imageUrl2}"))
    String imageUrl;
    @Value("${resAddress2}")
    String resAddress;
    public CommandLineRunnerImpl() {
    }

    @Autowired
    public CommandLineRunnerImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }


    @Override
    @Order(2)
    public void run(String... args) throws Exception {

        restaurantRepository.save(new Restaurant(id,restaurantName,imageUrl,resAddress));
    }
}
