package com.techelevator.dao;

import com.techelevator.model.Animal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcAnimalDao {

    private final JdbcTemplate jdbctemplate;

    public JdbcAnimalDao(JdbcTemplate jdbctemplate) {
        this.jdbctemplate = jdbctemplate;
    }






    private Animal mapRowToAnimal(SqlRowSet rs) {



        return null;
    }


}
