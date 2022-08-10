package com.techelevator.model;

public class Volunteer {

    private int volunteer_id;
    private String full_name;
    private String phone_number;
    private String email;
    private String bio;
    private String ref_full_name;
    private int ref_phone_number;
    private String ref_email;

    public Volunteer() {

    }

    public Volunteer(int volunteer_id, String full_name, String phone_number, String email, String bio,
                     String ref_full_name, int ref_phone_number, String ref_email) {
        this.volunteer_id = volunteer_id;
        this.full_name = full_name;
        this.phone_number = phone_number;
        this.email = email;
        this.bio = bio;
        this.ref_full_name = ref_full_name;
        this.ref_phone_number = ref_phone_number;
        this.ref_email = ref_email;
    }

    public int getVolunteer_id() {
        return volunteer_id;
    }

    public void setVolunteer_id(int volunteer_id) {
        this.volunteer_id = volunteer_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getRef_full_name() {
        return ref_full_name;
    }

    public void setRef_full_name(String ref_full_name) {
        this.ref_full_name = ref_full_name;
    }

    public int getRef_phone_number() {
        return ref_phone_number;
    }

    public void setRef_phone_number(int ref_phone_number) {
        this.ref_phone_number = ref_phone_number;
    }

    public String getRef_email() {
        return ref_email;
    }

    public void setRef_email(String ref_email) {
        this.ref_email = ref_email;
    }
}