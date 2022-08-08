package com.techelevator.dao;

import com.techelevator.model.Animal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcAnimalDaoTests extends BaseDaoTests{

    private JdbcAnimalDao sut;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        sut = new JdbcAnimalDao(jdbcTemplate);
    }

    @Test
    public void returns_animalList() {
        List<Animal> animals = sut.findAll();
        Assert.assertNotEquals("there should be data", 0, animals.size());
    }

}
