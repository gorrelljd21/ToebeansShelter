package com.techelevator.dao;

import com.techelevator.model.Volunteer;

import java.util.List;

public interface VolunteerDao {

    List<Volunteer> findAll();

    Volunteer findById(int volunteer_id);

    Volunteer findByName(String full_name);

    Volunteer findByEmail(String email);

    Volunteer findByUserId(int user_id);

    Volunteer findReferenceByVolunteer (int volunteer_id);

    boolean postVolunteerSubmission(Volunteer volunteer);

}
