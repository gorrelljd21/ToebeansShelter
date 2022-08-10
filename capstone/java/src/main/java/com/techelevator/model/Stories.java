package com.techelevator.model;

public class Stories {

    private int story_id;
    private String story_title;
    private String story_text;
    private int animal_id;

    public Stories() {

    }

    public Stories(int story_id, String story_title, String story_text, int animal_id) {
        this.story_id = story_id;
        this.story_title = story_title;
        this.story_text = story_text;
        this.animal_id = animal_id;
    }

    public int getStory_id() {
        return story_id;
    }

    public void setStory_id(int story_id) {
        this.story_id = story_id;
    }

    public String getStory_title() {
        return story_title;
    }

    public void setStory_title(String story_title) {
        this.story_title = story_title;
    }

    public String getStory_text() {
        return story_text;
    }

    public void setStory_text(String story_text) {
        this.story_text = story_text;
    }

    public int getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(int animal_id) {
        this.animal_id = animal_id;
    }
}
