package com.techelevator.controller;


import com.techelevator.dao.UserDao;
import com.techelevator.dao.VolunteerDao;
import com.techelevator.dao.VolunteerUserDao;
import com.techelevator.model.VolunteerUser;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class VolunteerUserController {

    private VolunteerUserDao volunteerUserDao;
    private VolunteerDao volunteerDao;
    private UserDao userDao;

    public VolunteerUserController(VolunteerUserDao volunteerUserDao, VolunteerDao volunteerDao, UserDao userDao) {
        this.volunteerUserDao = volunteerUserDao;
        this.volunteerDao = volunteerDao;
        this.userDao =userDao;
    }


    @GetMapping(path = "/volunteer-user/userid/{userId}")
    public int getVolunteerIdByUserId(@PathVariable int userId) {
        return volunteerUserDao.getVolunteerIdByUserId(userId);
    }

    @GetMapping(path = "/volunteer-user/volunteerid/{volunteerId}")
    public int getUserIdByVolunteerId(@PathVariable int volunteerId) {
        return volunteerUserDao.getUserIdByVolunteerId(volunteerId);
    }

    @PutMapping(path = "/volunteer-user")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertVolunteerUserKeys(@PathVariable int userId, @PathVariable int volunteerId) {
        volunteerUserDao.insertVolunteerUserKeys(userId, volunteerId);
    }

}
