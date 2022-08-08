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

    @GetMapping(path = "/animals/{type}")
    public List<Animal> findByType(@PathVariable String type) {
        return animalDao.listAnimalByType(type);
    }

    @GetMapping(path = "/animals/{animal_id}")
    public Animal getAnimalById(@PathVariable int animal_id) {
        return animalDao.getAnimalById(animal_id);
    }

    @GetMapping(path = "/animals/{animal_name}")
    public Animal getAnimalByName(@PathVariable String name) {
        return animalDao.getAnimalByName(name);
    }

}
