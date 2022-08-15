package com.techelevator.controller;


import com.techelevator.dao.UserDao;
import com.techelevator.dao.VolunteerDao;
import com.techelevator.dao.VolunteerUserDao;
import com.techelevator.model.VolunteerUser;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

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


    @PutMapping(path = "/volunteer-user")
    public void insertVolunteerUserKeys(@PathVariable int userId, @PathVariable int volunteerId) {
        volunteerUserDao.insertVolunteerUserKeys(userId, volunteerId);
    }

}
