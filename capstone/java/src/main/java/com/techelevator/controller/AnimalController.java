package com.techelevator.controller;


import com.techelevator.Exceptions.AnimalNotAddedException;
import com.techelevator.Exceptions.ThreadSleepTryCatch;
import com.techelevator.dao.AnimalDao;
import com.techelevator.dao.JdbcAnimalDao;
import com.techelevator.model.AddAnimal;
import com.techelevator.model.Animal;
import com.techelevator.model.FullAnimal;
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

    @PreAuthorize(("permitAll"))
    @GetMapping(path = "/adopted-animals")
    public List<Animal> getAdoptedAnimals() {
        return animalDao.adoptionStatus();
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

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_VOLUNTEER')")
    @PutMapping(path = "/update-pet/{animalId}")
    public Animal updateAnimal(@Valid @RequestBody Animal animal, @PathVariable int animalId) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return animalDao.updateAnimal(animal, animalId);
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

    @PreAuthorize("permitAll")
    @GetMapping("/oneOfEach")
    public List<FullAnimal> getOneOfEachType() {
        return animalDao.getOneOfEachType();
    }

    @PreAuthorize("permitAll")
    @GetMapping("/animals/type/{id}/limit/{limit}/offset/{offset}")
    public List<FullAnimal> getPageByType(@PathVariable int id, @PathVariable int limit, @PathVariable int offset) {
        return animalDao.getAnimalsByTypePage(limit, offset, id);
    }

    @PreAuthorize("permitAll")
    @GetMapping("count/{type}")
    public int getCountByType(@PathVariable int type){
        return animalDao.getCountByType(type);
    }

    @PreAuthorize("permitAll")
    @GetMapping("/adopted")
    public List<FullAnimal> getAdopted() {
        return animalDao.getAdopted();
    }

}
