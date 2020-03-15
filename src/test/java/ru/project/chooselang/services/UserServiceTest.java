package ru.project.chooselang.services;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.project.chooselang.dao.UserRepository;
import ru.project.chooselang.entity.Role;
import ru.project.chooselang.entity.User;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void addUser() {
        User user = new User();
        byte answer = 0;

        Assert.assertEquals(answer, userService.addUser(user));
        Assert.assertTrue(CoreMatchers.is(user.getRoles()).matches(Collections.singleton(Role.USER)));
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }

    @Test
    public void addUserFailTest() {
        User user = new User();
        byte answer = 2;
        user.setUsername("John");

        Mockito.doReturn(true)
                .when(userRepository).existsByUsername("John");

        Assert.assertEquals(answer, userService.addUser(user));
        Mockito.verify(userRepository, Mockito.times(0)).save(user);
    }


    @Test
    public void addBook() {
    }

    @Test
    public void addBookFailTest() {
        String nameBook = "";
        String username = "user123";
        byte answer = 1;

        Mockito.doReturn(false)
                .when(userRepository).existsByUsername(username);

        Assert.assertEquals(answer, userService.addBook(nameBook,username));
    }
}