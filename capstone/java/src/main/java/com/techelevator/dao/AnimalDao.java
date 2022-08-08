package com.techelevator.dao;


import com.techelevator.model.Animal;

import java.util.List;

public interface AnimalDao {

    List<Animal> findAll();

    List<Animal> listAnimalByType(String type);

    Animal getAnimalById(String animal_id);

    Animal getAnimalByName(String name);

}
