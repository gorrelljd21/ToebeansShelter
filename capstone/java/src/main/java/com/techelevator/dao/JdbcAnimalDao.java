package com.techelevator.dao;

import com.techelevator.model.AddAnimal;
import com.techelevator.model.Animal;
import com.techelevator.model.FullAnimal;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        String sql = "SELECT animal_id, name, breed, age, bio, animal_type_id " +
                "FROM animals " +
                "ORDER BY animal_id " +
                "limit ? offset ?";
        SqlRowSet result = jdbctemplate.queryForRowSet(sql, limit, offset);
        while(result.next()){
            animals.add(mapRowToAnimal(result));
        }

        return animals;
    }

    @Override
    public boolean addAnimal(AddAnimal animal){
        String sql = "INSERT INTO animals (name, breed, age, bio, animal_type_id) VALUES (?,?,?,?,?); "+
                "INSERT INTO animal_photos (animal_id, photo_link) VALUES ((SELECT animal_id FROM animals WHERE name = ? AND bio = ? AND animal_type_id = ?),?);";
        try {
            jdbctemplate.update(sql, animal.getName(), animal.getBreed(), animal.getAge(), animal.getBio(), animal.getAnimal_type_id(), animal.getName(), animal.getBio(), animal.getAnimal_type_id(), animal.getLink());
            return true;
        }
        catch (DataAccessException e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Animal updateAnimal(Animal animal, int animal_id) {
        String sql = "update animals set name = ?, breed = ?, age = ?, bio = ?, animal_type_id = ? where animal_id = ?;";
            jdbctemplate.update(sql, animal.getName(), animal.getBreed(), animal.getAge(), animal.getBio(), animal.getAnimal_type_id(), animal_id);
            return animal;
    }

    @Override
    public List<FullAnimal> getOneOfEachType() {
        String sql = "SELECT distinct ON (animal_type_id) animal_type_id, " +
                "animals.animal_id," +
                "name, " +
                "breed, " +
                "age," +
                "bio, " +
                "photo_link " +
                "FROM animals JOIN animal_photos ON animal_photos.animal_id = animals.animal_id;";
        List<FullAnimal> animals = new ArrayList<>();
        SqlRowSet result =  jdbctemplate.queryForRowSet(sql);
        while(result.next()){
            FullAnimal animal = mapRowToFullAnimal(result);
            animals.add(animal);
        }
        return animals;
    }

    public List<FullAnimal> getAnimalsByTypePage(int limit, int offset, int type) {
        List<FullAnimal> animals = new ArrayList<>();
        String sql = "SELECT animal_type_id, " +
                "animals.animal_id, " +
                "name, " +
                "breed, " +
                "age," +
                "bio, " +
                "photo_link " +
                "FROM animals JOIN animal_photos ON animal_photos.animal_id = animals.animal_id " +
                "WHERE animal_type_id = ? " +
                "limit ? offset ?";
        SqlRowSet result = jdbctemplate.queryForRowSet(sql, type, limit, offset);
        while(result.next()){
            animals.add(mapRowToFullAnimal(result));
        }
        return animals;
    }

    public int getCountByType(int type) {
        String sql = "SELECT COUNT(*) as num FROM animals WHERE animal_type_id = ?;";
        SqlRowSet result = jdbctemplate.queryForRowSet(sql, type);
        result.next();
        return result.getInt("num");
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
    private FullAnimal mapRowToFullAnimal(SqlRowSet rs) {
        FullAnimal animal = new FullAnimal();
        animal.setAnimal_id(rs.getInt("animal_id"));
        animal.setName(rs.getString("name"));
        animal.setBreed(rs.getString("breed"));
        animal.setAge(rs.getInt("age"));
        animal.setBio(rs.getString("bio"));
        animal.setAnimal_type_id(rs.getInt("animal_type_id"));
        animal.setPhoto_link(rs.getString("photo_link"));
        return animal;
    }
}
