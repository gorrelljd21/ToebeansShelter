package com.techelevator.dao;

import com.techelevator.model.Stories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class JdbcStories implements StoriesDao{

    private final JdbcTemplate jdbctemplate;

    public JdbcStories(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    @Override
    public List<Stories> getAll() {
        return null;
    }

    @Override
    public List<Stories> getByAnimalId(int animal_id) {
        return null;
    }


    @Override
    public Stories getById(int story_id) {
        return null;
    }





    private Stories mapRowStories(SqlRowSet rs) {
        Stories story = new Stories();
        story.setStory_id(rs.getInt("story_id"));
        story.setStory_title(rs.getString("story_title"));
        story.setStory_text(rs.getString("story_text"));
        story.setAnimal_id(rs.getInt("animal_id"));
        return story;
    }

}
