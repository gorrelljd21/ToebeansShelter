package com.techelevator.dao;

import com.techelevator.model.Volunteer;
import com.techelevator.model.VolunteerNotFoundException;

import java.util.List;

public interface VolunteerDao {

    List<Volunteer> findAll();

    Volunteer findById(int volunteer_id);

    Volunteer findByName(String full_name);

    Volunteer findByEmail(String email);

    Volunteer findByUserId(int user_id);

    Volunteer findReferenceByVolunteer (int volunteer_id);

    boolean postVolunteerSubmission(Volunteer volunteer);

    boolean approveApp(Volunteer volunteer, int volunteer_id) throws VolunteerNotFoundException;

    boolean denyApp(Volunteer volunteer, int volunteer_id) throws VolunteerNotFoundException;

    void deleteVolunteer(int volunteer_id) throws VolunteerNotFoundException;





}
