package com.techelevator.controller;


import com.techelevator.Exceptions.ThreadSleepTryCatch;
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
    ThreadSleepTryCatch threadSleepTryCatch = new ThreadSleepTryCatch();

    @GetMapping(path ="/animals")
    public List<Animal> findAll() throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return animalDao.findAll();
    }

    @GetMapping(path = "/animals/limit/{limit}/offset/{offset}")
    public List<Animal> getAnimalsByPage(@PathVariable int limit, @PathVariable int offset) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return animalDao.getAnimalPage(limit, offset);
    }

    @GetMapping(path = "/animals/type/{animal_type_id}")
    public List<Animal> findByType(@PathVariable int animal_type_id) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return animalDao.listAnimalByType(animal_type_id);
    }

    @GetMapping(path = "/animals/id/{animal_id}")
    public Animal getAnimalById(@PathVariable int animal_id) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return animalDao.getAnimalById(animal_id);
    }

    @GetMapping(path = "/animals/name/{name}")
    public Animal getAnimalByName(@PathVariable String name) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return animalDao.getAnimalByName(name);
    }


}
