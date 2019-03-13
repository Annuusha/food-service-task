package com.stackroute.foodieservice.service;


import com.stackroute.foodieservice.domain.Restaurant;
import com.stackroute.foodieservice.exceptions.RestaurantAlreadyExistsException;
import com.stackroute.foodieservice.exceptions.RestaurantNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RestaurantService {
  public Restaurant save(Restaurant restaurant)throws RestaurantAlreadyExistsException;
    public void deleteById(int id);
    public Restaurant getById(int id)throws RestaurantNotFoundException;
    public Restaurant updateRestaurant(Restaurant restaurant,int id)throws RestaurantNotFoundException;
    public List<Restaurant> findByName(String name);
}
