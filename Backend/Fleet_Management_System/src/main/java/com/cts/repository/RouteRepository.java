package com.cts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.entity.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {

	Route findByrouteName(String routeName);

	

	

}
