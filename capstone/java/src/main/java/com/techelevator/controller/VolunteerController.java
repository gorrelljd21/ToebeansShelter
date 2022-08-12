package com.techelevator.controller;

import com.techelevator.Exceptions.ThreadSleepTryCatch;
import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.UserAlreadyExistsException;
import com.techelevator.model.UserNotFoundException;
import com.techelevator.model.Volunteer;
import com.techelevator.model.VolunteerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class VolunteerController {

    private VolunteerDao volunteerDao;
    ThreadSleepTryCatch threadSleepTryCatch = new ThreadSleepTryCatch();

    public VolunteerController(VolunteerDao volunteerDao) {
        this.volunteerDao = volunteerDao;
    }

    //    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/volunteers")
    public List<Volunteer> findAll() throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return volunteerDao.findAll();
    }

    //    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/volunteers/{volunteer_id}")
    public Volunteer findById(@PathVariable int volunteer_id) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return volunteerDao.findById(volunteer_id);
    }

    //    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/volunteers/name/{full_name}")
    public Volunteer findByName(@PathVariable  String full_name) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return volunteerDao.findByName(full_name);
    }

    //    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/volunteers/email/{email}")
    public Volunteer findByEmail(@PathVariable String email) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return volunteerDao.findByEmail(email);
    }

    //    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/volunteers/user/{user_id}")
    public Volunteer findByUserId(@PathVariable int user_id) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return volunteerDao.findByUserId(user_id);
    }

    //    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping(path = "/volunteers/reference/{volunteer_id}")
    public Volunteer findReferenceByVolunteer(@PathVariable int volunteer_id) throws InterruptedException {
        threadSleepTryCatch.threadSleep();
        return volunteerDao.findReferenceByVolunteer(volunteer_id);
    }

    //    @PreAuthorize("permitAll")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/volunteers/submit")
    public Volunteer createNewVolunteer(@Valid @RequestBody Volunteer newVolunteer) throws InterruptedException {
         volunteerDao.postVolunteerSubmission(newVolunteer);
        threadSleepTryCatch.threadSleep();
        return newVolunteer;
    }

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping(path = "/volunteers/{volunteer_id}")
    public boolean changeAppStatus(@Valid @RequestBody Volunteer volunteer, @PathVariable int volunteer_id) throws VolunteerNotFoundException {
        return volunteerDao.approveApp(volunteer, volunteer_id);
    }

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(path = "/volunteers/{volunteer_id}")
    public void delete(@PathVariable int volunteer_id) throws VolunteerNotFoundException {
        volunteerDao.deleteVolunteer(volunteer_id);
    }

}