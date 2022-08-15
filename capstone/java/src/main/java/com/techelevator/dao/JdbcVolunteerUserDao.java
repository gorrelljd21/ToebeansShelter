package com.techelevator.dao;

import com.techelevator.model.VolunteerUser;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcVolunteerUserDao implements VolunteerUserDao {

    private final JdbcTemplate jdbcTemplate;


    public JdbcVolunteerUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getVolunteerIdByUserId(int userId) {
        return 0;
    }

    @Override
    public int getUserIdByVolunteerId(int volunteerId) {

        return 0;
    }

    @Override
    public boolean insertVolunteerUserKeys(int userId, int volunteerId) {
        String sql = "INSERT INTO volunteers_users (volunteer_id, user_id) " +
                "VALUES (volunteer_id, user_id); ";
        try {
            jdbcTemplate.update(sql, userId, volunteerId);
            return true;
        } catch (DataAccessException e) {
            System.out.println(e);
        }
        return false;
    }

    private VolunteerUser mapToVolunteerUser(SqlRowSet rs) {
        VolunteerUser vm = new VolunteerUser();
        vm.setUserId(rs.getInt("user_id"));
        vm.setVolunteerId(rs.getInt("volunteer_id"));
        return vm;
    }

}
