package com.techelevator.dao;

import com.techelevator.model.UserNotFoundException;
import com.techelevator.model.VolunteerNotFoundException;
import com.techelevator.model.VolunteerUser;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        String sql = "SELECT volunteer_id FROM volunteers " +
                "JOIN volunteers_users ON volunteers.volunteer_id = volunteers_users.volunteer_id " +
                "JOIN users on volunteers_users.user_id = users.user_id " +
                "WHERE users.user_id = ?; ";

        int volunteerId;
        try {
            volunteerId = jdbcTemplate.queryForObject(sql, int.class, userId);
        } catch (EmptyResultDataAccessException e) {
            throw new UserNotFoundException();
        }
        return volunteerId;
    }

    @Override
    public int getUserIdByVolunteerId(int volunteerId) {
        String sql = "SELECT user_id FROM users " +
                "JOIN volunteers_users ON users.user_id = volunteers_users.user_id " +
                "JOIN volunteers ON volunteers_users.volunteer_id = volunteers.volunteer_id " +
                "WHERE volunteers.volunteer_id = ?; ";

        int userId;
        try {
            userId = jdbcTemplate.queryForObject(sql, int.class, volunteerId);
        } catch (EmptyResultDataAccessException e) {
            throw new VolunteerNotFoundException();
        }
        return userId;
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
