package com.techelevator.dao;

import com.techelevator.model.Stories;

import java.util.List;

public interface StoriesDao {

    List<Stories> getAll();

    List<Stories> getByAnimalId(int animal_id);

    Stories getById(int story_id);

}
