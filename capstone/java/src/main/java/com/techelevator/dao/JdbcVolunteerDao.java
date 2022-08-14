package com.techelevator.dao;

import com.techelevator.model.Volunteer;
import com.techelevator.model.VolunteerNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcVolunteerDao implements VolunteerDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcVolunteerDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Volunteer> findAll() {
        List<Volunteer> volunteersList = new ArrayList<>();

        String volunteerSql =
                "SELECT volunteer_id, full_name, phone_number, email, bio, ref_full_name, " +
                        " ref_phone_number, ref_email, app_status " +
                        "FROM volunteers; ";
        SqlRowSet result = jdbcTemplate.queryForRowSet(volunteerSql);
        while(result.next()){
            volunteersList.add(mapRowToVolunteer(result));
        }
        return volunteersList;
    }

    @Override
    public Volunteer findById(int volunteer_id) {
        Volunteer volunteer = null;

        String sql =
                "SELECT volunteer_id, full_name, phone_number, email, bio, ref_full_name, ref_phone_number, ref_email, app_status " +
                        " FROM volunteers " +
                        " WHERE volunteer_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, volunteer_id);

       if (result.next()) {
           volunteer = mapRowToVolunteer(result);
       }
       return volunteer;
    }

    @Override
    public Volunteer findByName(String full_name) {
        Volunteer volunteer = null;

        String sql =
                "SELECT volunteer_id, full_name, phone_number, email, bio, ref_full_name, ref_phone_number, ref_email, app_status " +
                        " FROM volunteers" +
                        " WHERE full_name = ?; ";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, full_name);

        if (result.next()){
            volunteer = mapRowToVolunteer(result);
        }
        return volunteer;
    }

    @Override
    public Volunteer findByEmail(String email) {
        Volunteer volunteer = null;

        String sql =
                "SELECT volunteer_id, full_name, phone_number, email, bio, ref_full_name, ref_phone_number, ref_email, app_status " +
                        " FROM volunteers " +
                        " WHERE email = ?; ";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, email);

        if(result.next()){
            volunteer = mapRowToVolunteer(result);
        }
        return volunteer;
    }

    @Override
    public Volunteer findByUserId(int user_id) {
        Volunteer volunteer = null;

        String sql =
                "SELECT full_name, phone_number, email, bio, ref_full_name, ref_phone_number, ref_email, app_status " +
                        "FROM volunteers " +
                        "JOIN volunteers_users " +
                        "ON volunteers.volunteer_id = volunteers_users.volunteer_id " +
                        "JOIN users " +
                        "ON volunteers_users.user_id = users.user_id " +
                        "WHERE users.user_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, user_id);

        if(result.next()){
            volunteer = mapRowToVolunteer(result);
        }

        return volunteer;
    }

    @Override
    public Volunteer findReferenceByVolunteer (int volunteer_id) {
        Volunteer volunteer = null;

        String sql =
                "SELECT ref_full_name, ref_phone_number, ref_email" +
                        " FROM volunteers" +
                        " WHERE volunteer_id = ?; ";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, volunteer_id);

        if(result.next()) {
            volunteer = mapRowToVolunteer(result);
        }

        return volunteer;
    }

    @Override
    public boolean postVolunteerSubmission(Volunteer volunteer) {
        String sql = "INSERT INTO volunteers (full_name, phone_number, email, bio, ref_full_name, ref_phone_number, ref_email, app_status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING volunteer_id; ";

        Integer newVolunteerId;
            try {
                newVolunteerId = jdbcTemplate.queryForObject(sql, Integer.class, volunteer.getFull_name(), volunteer.getPhone_number(),
                        volunteer.getEmail(), volunteer.getBio(), volunteer.getRef_full_name(), volunteer.getRef_phone_number(),
                        volunteer.getRef_email(), volunteer.getApp_status());
            } catch (DataAccessException e) {
                System.out.println(e.getLocalizedMessage());
                return false;
            }
            return true;
    }

    @Override
    public boolean approveApp(Volunteer volunteer, int volunteer_id) throws VolunteerNotFoundException {
        String sql = "UPDATE volunteers SET full_name = ?, phone_number = ?, email =?, bio = ?," +
                "ref_full_name = ?, ref_phone_number = ?, ref_email = ?, app_status = ? " +
                "WHERE volunteer_id = ?; ";

        return jdbcTemplate.update(sql, volunteer.getFull_name(), volunteer.getPhone_number(),
                volunteer.getEmail(), volunteer.getBio(), volunteer.getRef_full_name(), volunteer.getRef_phone_number(),
                volunteer.getRef_email(), volunteer.getApp_status(), volunteer_id) == 1;

    }

    @Override
    public void deleteVolunteer(int volunteer_id) throws VolunteerNotFoundException {
        String sql = "DELETE FROM volunteers " +
                "WHERE volunteer_id = ?; ";
        jdbcTemplate.update(sql, volunteer_id);
    }



    private Volunteer mapRowToVolunteer(SqlRowSet rs) {
      Volunteer volunteer = new Volunteer();

        volunteer.setVolunteer_id(rs.getInt("volunteer_id"));
        volunteer.setFull_name(rs.getString("full_name"));
        volunteer.setPhone_number(rs.getString("phone_number"));
        volunteer.setEmail(rs.getString("email"));
        volunteer.setBio(rs.getString("bio"));
        volunteer.setRef_full_name(rs.getString("ref_full_name"));
        volunteer.setRef_phone_number(rs.getString("ref_phone_number"));
        volunteer.setRef_email(rs.getString("ref_email"));
        volunteer.setApp_status(rs.getString("app_status"));
      return volunteer;
    }
}
