package com.techelevator.model;

public class AddAnimal {
    private String name;
    private String breed;
    private int age;
    private String bio;
    private int animal_type_id;
    private String link;

    public AddAnimal(){

    }

    public AddAnimal(String name, String breed, int age, String bio, int animal_type_id, String link) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.bio = bio;
        this.animal_type_id = animal_type_id;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getAnimal_type_id() {
        return animal_type_id;
    }

    public void setAnimal_type_id(int animal_type_id) {
        this.animal_type_id = animal_type_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
