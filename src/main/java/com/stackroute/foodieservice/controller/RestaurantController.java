package com.stackroute.foodieservice.controller;

import com.stackroute.foodieservice.domain.Restaurant;
import com.stackroute.foodieservice.exceptions.RestaurantAlreadyExistsException;
import com.stackroute.foodieservice.exceptions.RestaurantNotFoundException;
import com.stackroute.foodieservice.service.RestaurantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RestaurantController {
    private RestaurantServiceImpl restaurantServiceImpl;
    @Autowired
    public RestaurantController(RestaurantServiceImpl restaurantServiceImpl) {
        this.restaurantServiceImpl = restaurantServiceImpl;
    }

    @PostMapping("restaurant")
    public ResponseEntity<Restaurant> save(@RequestBody Restaurant restaurant)throws RestaurantAlreadyExistsException{
        ResponseEntity responseEntity;
            Restaurant result = restaurantServiceImpl.save(restaurant);
            responseEntity = new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
        return responseEntity;

    }
    @DeleteMapping("restaurants/{id}")
    public void deleteById(@PathVariable int id){
        restaurantServiceImpl.deleteById(id);
    }
    @GetMapping("restaurants")
    public List<Restaurant> getAll(){
        List<Restaurant> list= restaurantServiceImpl.getAllRestaurant();
        return list;
    }


    @GetMapping("/restaurants/{restaurantName}")
    public ResponseEntity<List> findByName(@PathVariable String restaurantName)
    {
        List<Restaurant> restaurantList= (List<Restaurant>) restaurantServiceImpl.findByName(restaurantName);
        return new ResponseEntity<List>(restaurantList,HttpStatus.OK);
    }

    @GetMapping("restaurant/{id}")
    public ResponseEntity<?> getById(@PathVariable int id)throws RestaurantNotFoundException{
        ResponseEntity responseEntity;
            restaurantServiceImpl.getById(id);
            responseEntity=new ResponseEntity<String>("successfully fetched",HttpStatus.FOUND);
        return responseEntity;

    }
    @PutMapping("restaurant/{id}")
    public ResponseEntity<String> update(@RequestBody Restaurant restaurant,@PathVariable("id") int id) throws RestaurantNotFoundException{
        ResponseEntity responseEntity;
            restaurantServiceImpl.updateRestaurant(restaurant, id);
            responseEntity = new ResponseEntity<String>("successfully updated", HttpStatus.FOUND);
        return responseEntity;
    }
}
