package com.techelevator.controller;

import com.techelevator.Exceptions.ThreadSleepTryCatch;
import com.techelevator.dao.StoriesDao;
import com.techelevator.model.Stories;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class StoryController {

    private StoriesDao storiesDao;
    ThreadSleepTryCatch threadSleepTryCatch = new ThreadSleepTryCatch();


    public StoryController(StoriesDao storiesDao) {
        this.storiesDao = storiesDao;
    }

    @GetMapping(path = "/stories")
    public List<Stories> getAllStories() throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return storiesDao.getAll();
    }

    @GetMapping(path = "/stories/animal/{animal_id}")
    public List<Stories> getStoriesByAnimalId(@PathVariable int animal_id) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return storiesDao.getByAnimalId(animal_id);
    }

    @GetMapping(path = "/stories/{story_id}")
    public Stories getStoryByStoryId(@PathVariable int story_id) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return storiesDao.getById(story_id);
    }


}
