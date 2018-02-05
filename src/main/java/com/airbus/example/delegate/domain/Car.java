package com.airbus.example.delegate.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User: stevedavis
 * Date: 05/02/2018
 * Time: 17:27
 * Description:
 */
@Entity
@Data
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String make;

    private String model;
}
