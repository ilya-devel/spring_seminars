package home.sem04_homework.repository;

import home.sem04_homework.models.User;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.logging.Level;

/**
 * Управление базы данных с информацией об участниках
 */
@Repository
@AllArgsConstructor
@Log
public class UserRepository {
    @Autowired
    private final JdbcTemplate jdbc;

    /**
     * Получить список всех участников из базы данных
     * @return
     */
    public List<User> getAllUsers() {
        String sql = "SELECT * FROM userTable";
        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setSecondName(r.getString("secondName"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };
        return jdbc.query(sql, userRowMapper);
    }

    /**
     * Добавить нового участника в базу
     * @param user
     */
    public void addNewUser(User user) {
        String sql = "INSERT INTO userTable (firstName,secondName,age,email) VALUES( ?, ?, ?, ?)";
        jdbc.update(sql, user.getFirstName()
                , user.getSecondName()
                , user.getAge()
                , user.getEmail());
        log.log(Level.INFO, "Add user in userTable: " + user);
    }

    /**
     * Получить участника по ID
     * @param id
     * @return
     */
    public User getUserById(int id) {
        try {
            String sql = "SELECT * FROM userTable WHERE id=?";
            return jdbc.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    /**
     * Удаление участника из базы
     * @param id
     */
    public void deleteById(int id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }

    /**
     * Обновление информации об участнике в базе
     * @param user
     * @return
     */
    public User update(User user) {
        jdbc.update("UPDATE userTable SET firstName=?, secondName=?, age=?, email=? WHERE id=?",
                new Object[] { user.getFirstName()
                        , user.getSecondName()
                        , user.getAge()
                        , user.getEmail()
                        , user.getId() });
        return user;
    }
}
