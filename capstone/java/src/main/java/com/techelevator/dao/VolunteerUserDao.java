package com.techelevator.dao;

public interface VolunteerUserDao {

    int getVolunteerIdByUserId(int userId);

    int getUserIdByVolunteerId(int volunteerId);

    boolean insertVolunteerUserKeys(int userId, int volunteerId);

}
