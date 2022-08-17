package com.techelevator.model;

public class FullAnimal extends Animal{

    private int animal_id;
    private String name;
    private String breed;
    private int age;
    private String bio;
    private int animal_type_id;
    private String photo_link;
    private boolean adopted;

    public FullAnimal() {};

    public FullAnimal(int animal_id, String name, String breed, int age, String bio, int animal_type_id, String photo_link, boolean adopted) {
        this.animal_id = animal_id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.bio = bio;
        this.animal_type_id = animal_type_id;
        this.photo_link = photo_link;
        this.adopted = adopted;
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

    public String getPhoto_link() {
        return photo_link;
    }

    public void setPhoto_link(String photo_link) {
        this.photo_link = photo_link;
    }

    public int getAnimal_type_id() {
        return animal_type_id;
    }

    public void setAnimal_type_id(int animal_type_id) {
        this.animal_type_id = animal_type_id;
    }

    @Override
    public boolean isAdopted() {
        return adopted;
    }

    @Override
    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }
}
