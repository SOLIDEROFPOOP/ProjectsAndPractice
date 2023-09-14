package Murat.Kapparov.JdbcCourse.JdbcStudyApp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void addTest(){
        User user = new User(1l , "John" , "John@gmail.com");
        userService.addUser(user);
    }
}