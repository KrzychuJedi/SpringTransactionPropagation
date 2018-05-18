package com.spring.transactions.service;

import com.spring.transactions.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testReadWriteSaveUser() {
        User user = new User("John");
        userService.readWriteSaveUser(user);
        User result = userService.readOnlyFindById(user.getId()).orElse(null);
        assertEquals(user, result);
    }

    @Test
    public void testReadOnlySaveUser() {
        User user = new User("Doe");
        userService.readOnlySaveUser(user);
        User result = userService.readOnlyFindById(user.getId()).orElse(null);
        assertEquals(user, result);
    }
}
