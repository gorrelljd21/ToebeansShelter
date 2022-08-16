package com.techelevator.controller;


import com.techelevator.Exceptions.AnimalNotAddedException;
import com.techelevator.Exceptions.ThreadSleepTryCatch;
import com.techelevator.dao.AnimalDao;
import com.techelevator.dao.JdbcAnimalDao;
import com.techelevator.model.AddAnimal;
import com.techelevator.model.Animal;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class AnimalController {

    private AnimalDao animalDao;

    public AnimalController(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }
    ThreadSleepTryCatch threadSleepTryCatch = new ThreadSleepTryCatch();

    @PreAuthorize("permitAll")
    @GetMapping(path ="/animals")
    public List<Animal> findAll() throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return animalDao.findAll();
    }

    @PreAuthorize("permitAll")
    @GetMapping(path = "/animals/limit/{limit}/offset/{offset}")
    public List<Animal> getAnimalsByPage(@PathVariable int limit, @PathVariable int offset) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return animalDao.getAnimalPage(limit, offset);
    }

    @PreAuthorize("permitAll")
    @GetMapping(path = "/animals/type/{animal_type_id}")
    public List<Animal> findByType(@PathVariable int animal_type_id) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return animalDao.listAnimalByType(animal_type_id);
    }

    @PreAuthorize("permitAll")
    @GetMapping(path = "/animals/id/{animal_id}")
    public Animal getAnimalById(@PathVariable int animal_id) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return animalDao.getAnimalById(animal_id);
    }

    //    @PreAuthorize("permitAll")
    @GetMapping(path = "/animals/name/{name}")
    public Animal getAnimalByName(@PathVariable String name) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return animalDao.getAnimalByName(name);
    }

    @PutMapping(path = "/update-pet/:animalId")
    public Animal updateAnimal(@Valid @RequestBody Animal animal, @PathVariable int animal_id) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return animalDao.updateAnimal(animal, animal_id);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_VOLUNTEER')")
    @PostMapping ("/animals")
    @ResponseStatus(HttpStatus.CREATED)
    public void addAnimal(@RequestBody AddAnimal animal) throws AnimalNotAddedException { //takes in an AddAnimal model, this includes a photo_link!!
        boolean result = animalDao.addAnimal(animal);
        if (!result){
            throw new AnimalNotAddedException();
        }
    }


}
