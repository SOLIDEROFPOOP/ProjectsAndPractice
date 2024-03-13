package com.example.springcache;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.logging.Logger;

@Slf4j
public class UserServiceTest extends AbstractTest{
    @Autowired
    private UserService userService;
    private static final Logger log = Logger.getLogger(UserServiceTest.class.getName());
    @Test
    public void get(){
        User user1 = userService.create(new User("Murat", "xd@gmail.com"));
        User user2 = userService.create(new User("Murat1", "xd1@gmail.com"));
        getAndPrint(user1.getId());
        getAndPrint(user2.getId());
        getAndPrint(user1.getId());
        getAndPrint(user2.getId());
    }
    private void getAndPrint(Long id) {
        log.info("user found: {"+ userService.get(id) + "}");
    }
    @Test
    public void create() {
        createAndPrint("Ivan", "ivan@mail.ru");
        createAndPrint("Ivan", "ivan1122@mail.ru");
        createAndPrint("Sergey", "ivan@mail.ru");

        log.info("all entries are below:");
        userService.getAll().forEach(u -> log.info("{}" + u.toString()));
    }

    private void createAndPrint(String name, String email) {
        log.info("created user: {}" + userService.create(name, email));
    }
}
