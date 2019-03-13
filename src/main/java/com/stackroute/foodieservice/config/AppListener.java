package com.stackroute.foodieservice.config;

import com.stackroute.foodieservice.domain.Restaurant;
import com.stackroute.foodieservice.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class AppListener implements ApplicationListener {
private RestaurantRepository restaurantRepository;

@Autowired
Environment environment;

      @Value("${id1}")
      int id;
//    @Value("${restaurantName}")
//    String restaurantName;
//    @Value(("${imageUrl}"))
//    String imageUrl;
//    @Value("${resAddress}")
//    String resAddress;
    public AppListener() {
    }

    @Autowired
    public AppListener(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    @Order(1)
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        restaurantRepository.save(new Restaurant(id,environment.getProperty("restaurantName1"),environment.getProperty("imageUrl1"),environment.getProperty("resAddress1")));

    }
}
