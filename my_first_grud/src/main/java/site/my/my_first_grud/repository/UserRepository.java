package site.my.my_first_grud.repository;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.IncorrectResultSetColumnCountException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import site.my.my_first_grud.model.User;

import java.util.List;

@Repository
public class UserRepository{
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES( ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    public User update(User user) {
        jdbc.update("UPDATE userTable SET firstName=?, lastName=? WHERE id=?",
                new Object[] { user.getFirstName(), user.getLastName(), user.getId() });
        return user;
    }
    public User getOne(int id) {
        try {
            String sql = "SELECT * FROM userTable WHERE id=?";
            return jdbc.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }
}
