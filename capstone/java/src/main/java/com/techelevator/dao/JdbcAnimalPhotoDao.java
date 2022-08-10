package com.techelevator.dao;

import com.techelevator.model.AnimalPhoto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAnimalPhotoDao implements  AnimalPhotoDao {

    private final JdbcTemplate jdbctemplate;

    public JdbcAnimalPhotoDao(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }

    @Override
    public List<AnimalPhoto> findAllPhotos() {
        List<AnimalPhoto> photos = new ArrayList<>();
        String sql = "SELECT photo_id, photo_link, animal_id " +
                "FROM " +
                "animal_photos; ";
        SqlRowSet results = jdbctemplate.queryForRowSet(sql);
        while(results.next()) {
            AnimalPhoto photo = mapRowToPhoto(results);
            photos.add(photo);
        }
        return photos;
    }

    @Override
    public List<AnimalPhoto> findByAnimalId(int animal_id) {
        List<AnimalPhoto> photos = new ArrayList<>();
        String sql = "SELECT photo_id, photo_link, animal_id " +
                "FROM animal_photos " +
                "WHERE " +
                "animal_id = ?; ";
        SqlRowSet results = jdbctemplate.queryForRowSet(sql, animal_id);
        while(results.next()) {
            AnimalPhoto photo = mapRowToPhoto(results);
            photos.add(photo);
        }
        return photos;
    }

    @Override
    public AnimalPhoto getPhotoByPhotoId(int photo_id) {
        AnimalPhoto photo = null;
        String sql = "SELECT photo_id, photo_link, animal_id " +
                "FROM animal_photos " +
                "WHERE " +
                "photo_id = ?; ";
        SqlRowSet result = jdbctemplate.queryForRowSet(sql, photo_id);
        if (result.next()) {
            photo = mapRowToPhoto(result);
        }
        return photo;
    }

    @Override
    public List<AnimalPhoto> getPhotosPage(int limit, int offset) {
        String sql = "select animal_id, photo_id, photo_link" +
                " From animal_photos" +
                " ORDER BY animal_id, photo_id" +
                " LIMIT ?" +
                " OFFSET ?;";
        List<AnimalPhoto> photos = new ArrayList<>();
        SqlRowSet results = jdbctemplate.queryForRowSet(sql, limit, offset);
        while(results.next()) {
            AnimalPhoto photo = mapRowToPhoto(results);
            photos.add(photo);
        }
        return photos;
    }

    private AnimalPhoto mapRowToPhoto(SqlRowSet rs) {
        AnimalPhoto photo = new AnimalPhoto();
        photo.setPhoto_id(rs.getInt("photo_id"));
        photo.setPhoto_link(rs.getString("photo_link"));
        photo.setAnimal_id(rs.getInt("animal_id"));

        return photo;
    }

}
