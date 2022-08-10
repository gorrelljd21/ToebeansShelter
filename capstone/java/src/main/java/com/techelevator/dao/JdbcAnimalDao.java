package com.techelevator.dao;

import com.techelevator.model.Animal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class JdbcAnimalDao implements AnimalDao {

    private final JdbcTemplate jdbctemplate;

    public JdbcAnimalDao(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    @Override
    public List<Animal> findAll() {
        List<Animal> animals = new ArrayList<>();

        String sql = "SELECT animal_id, name, breed, age, bio, animal_type_id " +
                " FROM " +
                " animals; ";

        SqlRowSet results = jdbctemplate.queryForRowSet(sql);
        while(results.next()) {
            Animal animal = mapRowToAnimal(results);
            animals.add(animal);
        }
        return animals;
    }


    @Override
    public List<Animal> listAnimalByType(int animal_type_id) {
        List<Animal> animals = new ArrayList<>();

        String sql = "SELECT animal_id, name, breed, age, bio, animal_type_id " +
                "FROM " +
                "animals " +
                "WHERE " +
                "animal_type_id = ? " +
                "GROUP BY animal_id " +
                "ORDER BY animal_id; ";
        SqlRowSet results = jdbctemplate.queryForRowSet(sql, animal_type_id);
        while(results.next()) {
            Animal animal = mapRowToAnimal(results);
            animals.add(animal);
        }
        return animals;
    }

    @Override
    public Animal getAnimalById(int animal_id) {
        Animal animal = null;
        String sql = " SELECT animal_id, name, breed, age, bio, animal_type_id " +
                "FROM " +
                "animals " +
                "WHERE " +
                "animal_id = ?; ";
        SqlRowSet result = jdbctemplate.queryForRowSet(sql, animal_id);
        if (result.next()) {
            animal =  mapRowToAnimal(result);
        }
        return animal;
    }

    @Override
    public Animal getAnimalByName(String name) {
        Animal animal = null;
        String sql = " SELECT animal_id, name, breed, age, bio, animal_type_id " +
                "FROM " +
                "animals " +
                "WHERE " +
                "name = ?; ";
        SqlRowSet result = jdbctemplate.queryForRowSet(sql, name);
        if (result.next()) {
            animal = mapRowToAnimal(result);
        }
        return animal;
    }

    @Override
    public List<Animal> getAnimalPage(int limit, int offset) {
        List<Animal> animals = new ArrayList<>();
        String sql = "Select animal_id, name, breed, age, bio, animal_type_id from animals order by animal_id limit ? offset ?";
        SqlRowSet result = jdbctemplate.queryForRowSet(sql, limit, offset);
        while(result.next()){
            animals.add(mapRowToAnimal(result));
        }
//        Collections.shuffle(animals);
        return animals;
    }


    private Animal mapRowToAnimal(SqlRowSet rs) {
        Animal animal = new Animal();
        animal.setAnimal_id(rs.getInt("animal_id"));
        animal.setName(rs.getString("name"));
        animal.setBreed(rs.getString("breed"));
        animal.setAge(rs.getInt("age"));
        animal.setBio(rs.getString("bio"));
        animal.setAnimal_type_id(rs.getInt("animal_type_id"));
        return animal;
    }
}
