package com.techelevator.model.shelter;

public class Animal {

    private int animal_id;
    private String name;
    private String breed;
    private int age;
    private String bio;
    private int animal_type_id;

    public Animal(int animal_id, String name, String breed, int age, String bio, int animal_type_id) {
        this.animal_id = animal_id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.bio = bio;
        this.animal_type_id = animal_type_id;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
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
}
