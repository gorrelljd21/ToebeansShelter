package com.techelevator.dao;


import com.techelevator.model.AddAnimal;
import com.techelevator.model.Animal;
import com.techelevator.model.FullAnimal;

import java.util.List;

public interface AnimalDao {

    List<Animal> findAll();

    List<Animal> listAnimalByType(int animal_type_id);

    List<Animal> adoptionStatus(boolean adopted);

    Animal getAnimalById(int animal_id);

    Animal getAnimalByName(String name);

    List<Animal> getAnimalPage(int limit, int offset);

    boolean addAnimal(AddAnimal animal);

    Animal updateAnimal(Animal animal, int animal_id);

    List<FullAnimal> getOneOfEachType();

    List<FullAnimal> getAnimalsByTypePage(int limit, int offset, int type);

    int getCountByType(int type);

}
