package com.techelevator.controller;

import com.techelevator.dao.AnimalPhotoDao;
import com.techelevator.model.AnimalPhoto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PhotoController {
    private AnimalPhotoDao animalPhotoDao;

    public PhotoController(AnimalPhotoDao animalPhotoDao) {
        this.animalPhotoDao = animalPhotoDao;
    }

    @GetMapping(path = "/photos")
    public List<AnimalPhoto> findAllPhotos() {
        return this.animalPhotoDao.findAllPhotos();
    }

    @GetMapping(path = "/photos/animal/{animal_id}")
    public List<AnimalPhoto> findByAnimalId(@PathVariable int animal_id) {
        return animalPhotoDao.findByAnimalId(animal_id);
    }

    @GetMapping(path = "/photos/{photo_id}")
    public AnimalPhoto findByPhotoId(@PathVariable int photo_id) {
        return animalPhotoDao.getPhotoByPhotoId(photo_id);
    }

    @GetMapping(path = "/photos/limit/{limit}/offset/{offset}")
    public List<AnimalPhoto> getAnimalsByPage(@PathVariable int limit, @PathVariable int offset){
        return animalPhotoDao.getPhotosPage(limit, offset);
    }
}
