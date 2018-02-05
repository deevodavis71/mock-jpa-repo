package com.airbus.example.delegate.service;

import java.util.List;

import javax.smartcardio.CardTerminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airbus.example.delegate.domain.Car;
import com.airbus.example.delegate.repo.CarRepository;

/**
 * User: stevedavis
 * Date: 05/02/2018
 * Time: 17:31
 * Description:
 */
@Service
public class CarService {

    @Autowired
    private CarRepository repo;

    public List<Car> getCars() {


        List<Car> cars = repo.findAll();
        return cars;

    }

    public void save(Car car) {

        repo.save(car);
        repo.flush();

    }
}
