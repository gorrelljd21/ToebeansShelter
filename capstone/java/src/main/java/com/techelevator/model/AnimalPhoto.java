package com.techelevator.model;

public class AnimalPhoto {

    private int animal_id;
    private String photo_link;
    private int photo_id;

    public AnimalPhoto(int animal_id, String photo_link, int photo_id) {
        this.animal_id = animal_id;
        this.photo_link = photo_link;
        this.photo_id = photo_id;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }

    public String getPhoto_link() {
        return photo_link;
    }

    public void setPhoto_link(String photo_link) {
        this.photo_link = photo_link;
    }

    public int getPhoto_id() {
        return photo_id;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }
}
