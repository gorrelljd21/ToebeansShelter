package com.techelevator.model.shelter;

public class AnimalType {

    private int animal_type_id;
    private String type;


    public AnimalType(int animal_type_id, String type) {
        this.animal_type_id = animal_type_id;
        this.type = type;
    }

    public int getAnimal_type_id() {
        return animal_type_id;
    }

    public void setAnimal_type_id(int animal_type_id) {
        this.animal_type_id = animal_type_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
