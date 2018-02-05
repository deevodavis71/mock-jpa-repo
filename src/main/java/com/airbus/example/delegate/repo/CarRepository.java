package com.airbus.example.delegate.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airbus.example.delegate.domain.Car;

/**
 * User: stevedavis
 * Date: 05/02/2018
 * Time: 17:26
 * Description:
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
