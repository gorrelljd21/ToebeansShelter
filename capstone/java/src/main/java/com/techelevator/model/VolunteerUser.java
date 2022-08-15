package com.techelevator.model;

public class VolunteerUser {

    private int userId;
    private int volunteerId;

    public VolunteerUser() {
    }

    public VolunteerUser(int userId, int volunteerId) {
        this.userId = userId;
        this.volunteerId = volunteerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(int volunteerId) {
        this.volunteerId = volunteerId;
    }
}
