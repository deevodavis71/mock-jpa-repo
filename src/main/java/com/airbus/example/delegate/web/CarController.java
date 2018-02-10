package com.airbus.example.delegate.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airbus.example.delegate.domain.Car;
import com.airbus.example.delegate.service.CarService;

/**
 * User: stevedavis
 * Date: 05/02/2018
 * Time: 17:38
 * Description:
 */
@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private CarService service;

    @Autowired
    public CarController(CarService service) {

        Car car = new Car();
        car.setMake("BMW");
        car.setModel("M4");
        service.save(car);

        Car car2 = new Car();
        car2.setMake("BMW");
        car2.setModel("M5");
        service.save(car2);

        Car car3 = new Car();
        car3.setMake("BMW");
        car3.setModel("M6");
        service.save(car3);
    }

    @GetMapping("/cars")
    public List<Car> getCars(){

        return service.getCars();

    }

}
