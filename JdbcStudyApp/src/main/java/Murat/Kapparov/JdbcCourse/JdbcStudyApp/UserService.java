package Murat.Kapparov.JdbcCourse.JdbcStudyApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public User getById(Long id){
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql , new Object[]{id} , (rs, rowNum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            return user;
        });
    }
    public void addUser(User user){
        String sql = "INSERT INTO users (username , email) " +
                "VALUES (? , ?);";
        jdbcTemplate.update(sql , user.getUsername() , user.getEmail());
    }
}
