package com.techelevator.controller;


import com.techelevator.dao.AnimalDao;
import com.techelevator.model.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AnimalController {

    private AnimalDao animalDao;

    public AnimalController(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    @GetMapping(path ="/animals")
    public List<Animal> findAll() {
        return animalDao.findAll();
    }

    @GetMapping(path = "/animals/type/{animal_type_id}")
    public List<Animal> findByType(@PathVariable int animal_type_id) {
        return animalDao.listAnimalByType(animal_type_id);
    }

    @GetMapping(path = "/animals/id/{animal_id}")
    public Animal getAnimalById(@PathVariable int animal_id) {
        return animalDao.getAnimalById(animal_id);
    }

    @GetMapping(path = "/animals/name/{name}")
    public Animal getAnimalByName(@PathVariable String name) {
        return animalDao.getAnimalByName(name);
    }

}
