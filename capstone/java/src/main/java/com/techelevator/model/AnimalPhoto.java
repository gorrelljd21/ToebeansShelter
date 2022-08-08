package com.techelevator.model;

public class AnimalPhoto {

    private int photo_id;
    private String photo_link;
    private int animal_id;

    public AnimalPhoto() {

    }

    public AnimalPhoto(int photo_id, String photo_link, int animal_id) {
        this.photo_id = photo_id;
        this.photo_link = photo_link;
        this.animal_id = animal_id;
    }

    public int getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }

    public String getPhoto_link() {
        return photo_link;
    }

    public void setPhoto_link(String photo_link) {
        this.photo_link = photo_link;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }
}
