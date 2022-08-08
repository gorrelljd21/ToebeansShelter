package com.techelevator.dao;

import com.techelevator.model.AnimalPhoto;

import java.util.List;

public interface AnimalPhotoDao {

    List<AnimalPhoto> findAllPhotos();

    List<AnimalPhoto> findByAnimalId(int animal_id);

    AnimalPhoto getPhotoByPhotoId(int photo_id);

}
