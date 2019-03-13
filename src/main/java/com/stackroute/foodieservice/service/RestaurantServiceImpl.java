package com.stackroute.foodieservice.service;

import com.stackroute.foodieservice.domain.Restaurant;
import com.stackroute.foodieservice.exceptions.RestaurantAlreadyExistsException;
import com.stackroute.foodieservice.exceptions.RestaurantNotFoundException;
import com.stackroute.foodieservice.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantRepository restaurantRepository;
    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant save(Restaurant restaurant)throws RestaurantAlreadyExistsException {
        if(restaurantRepository.existsById(restaurant.getId()))
        {
            throw new RestaurantAlreadyExistsException("restaurant already exists");
        }
        Restaurant resultant= restaurantRepository.save(restaurant);
        if(restaurant==null)
        {
            throw new RestaurantAlreadyExistsException("restaurant already exists");
        }
        return resultant;
    }

    public void deleteById(int id)
    {
        restaurantRepository.deleteById(id);
    }

    public List<Restaurant> getAllRestaurant()
    {
        List<Restaurant> resultant=(List<Restaurant>) restaurantRepository.findAll();
        return resultant;
    }



    public Restaurant getById(int id)throws RestaurantNotFoundException
    {
        if(!restaurantRepository.existsById(id)){
            throw new RestaurantNotFoundException("restaurant not found exception");
        }
        Optional<Restaurant> result= restaurantRepository.findById(id);
         return result.get();
    }

    public Restaurant updateRestaurant(Restaurant restaurant,int id)throws RestaurantNotFoundException
    {
        restaurant.setId(id);

        if(!restaurantRepository.existsById(id)) {
            System.out.println(id);
            throw new RestaurantNotFoundException("restaurant already exists");
        }

            Optional<Restaurant> result = restaurantRepository.findById(id);
            Restaurant fetchedRestaurant = result.get();
            fetchedRestaurant.setImageUrl(restaurant.getImageUrl());
            fetchedRestaurant.setResAddress(restaurant.getResAddress());
            fetchedRestaurant.setRestaurantName(restaurant.getRestaurantName());
            return restaurantRepository.save(fetchedRestaurant);

    }

    @Override
    public List<Restaurant> findByName(String name) {
    return restaurantRepository.findByName(name);
    }
}
