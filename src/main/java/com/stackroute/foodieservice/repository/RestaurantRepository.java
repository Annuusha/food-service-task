package com.stackroute.foodieservice.repository;

import com.stackroute.foodieservice.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant,Integer> {
    @Query(value = "select res from Restaurant res where res.restaurantName=?1")
    List<Restaurant> findByName(String name);
}
