package com.techelevator.dao;


import com.techelevator.model.Animal;

import java.util.List;

public interface AnimalDao {

    List<Animal> findAll();

    List<Animal> listAnimalByType(int animal_type_id);

    Animal getAnimalById(int animal_id);

    Animal getAnimalByName(String name);

    List<Animal> getAnimalPage(int limit, int offset);

}
