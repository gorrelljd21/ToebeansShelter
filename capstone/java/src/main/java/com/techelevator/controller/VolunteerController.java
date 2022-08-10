package com.techelevator.controller;

import com.techelevator.dao.VolunteerDao;
import com.techelevator.model.Volunteer;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class VolunteerController {

    private VolunteerDao volunteerDao;

    public VolunteerController(VolunteerDao volunteerDao) {
        this.volunteerDao = volunteerDao;
    }

    @GetMapping(path = "/volunteer")
    public List<Volunteer> findAll() {
        return volunteerDao.findAll();
    }

    @GetMapping(path = "/volunteer/{volunteer_id}")
    public Volunteer findById(@PathVariable int volunteer_id) {
        return volunteerDao.findById(volunteer_id);
    }

    @GetMapping(path = "/volunteer/name/{full_name}")
    public Volunteer findByName(@PathVariable  String full_name) {
        return volunteerDao.findByName(full_name);
    }

    @GetMapping(path = "/volunteer/email/{email}")
    public Volunteer findByEmail(@PathVariable String email) {
        return volunteerDao.findByEmail(email);
    }

    @GetMapping(path = "/volunteer/user/{user_id}")
    public Volunteer findByUserId(@PathVariable int user_id) {
        return volunteerDao.findByUserId(user_id);
    }

    @GetMapping(path = "/volunteer/reference/{volunteer_id}")
    public Volunteer findReferenceByVolunteer(@PathVariable int volunteer_id) {
        return volunteerDao.findReferenceByVolunteer(volunteer_id);
    }


}
