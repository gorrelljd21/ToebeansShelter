package com.techelevator.controller;

import com.techelevator.Exceptions.ThreadSleepTryCatch;
import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.UserAlreadyExistsException;
import com.techelevator.model.UserNotFoundException;
import com.techelevator.model.Volunteer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class VolunteerController {

    private VolunteerDao volunteerDao;
    ThreadSleepTryCatch threadSleepTryCatch = new ThreadSleepTryCatch();

    public VolunteerController(VolunteerDao volunteerDao) {
        this.volunteerDao = volunteerDao;
    }

    @GetMapping(path = "/volunteers")
    public List<Volunteer> findAll() throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return volunteerDao.findAll();
    }

    @GetMapping(path = "/volunteers/{volunteer_id}")
    public Volunteer findById(@PathVariable int volunteer_id) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return volunteerDao.findById(volunteer_id);
    }

    @GetMapping(path = "/volunteers/name/{full_name}")
    public Volunteer findByName(@PathVariable  String full_name) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return volunteerDao.findByName(full_name);
    }

    @GetMapping(path = "/volunteers/email/{email}")
    public Volunteer findByEmail(@PathVariable String email) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return volunteerDao.findByEmail(email);
    }

    @GetMapping(path = "/volunteers/user/{user_id}")
    public Volunteer findByUserId(@PathVariable int user_id) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return volunteerDao.findByUserId(user_id);
    }

    @GetMapping(path = "/volunteers/reference/{volunteer_id}")
    public Volunteer findReferenceByVolunteer(@PathVariable int volunteer_id) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return volunteerDao.findReferenceByVolunteer(volunteer_id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/volunteers/submit")
    public Volunteer createNewVolunteer(@Valid @RequestBody Volunteer newVolunteer) throws InterruptedException {
         volunteerDao.postVolunteerSubmission(newVolunteer);
        threadSleepTryCatch.threadSleep();
        return newVolunteer;
    }


}
