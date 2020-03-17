package ru.project.chooselang.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.chooselang.dao.UserRepository;
import ru.project.chooselang.entity.User;

import javax.transaction.Transactional;

/**
 * Admin service class
 * @author NoFunny
 * @version 1.0
 */

@Slf4j
@Service
public class AdminService  {

    @Autowired
    UserRepository userRepository;

    /**
     * This method needed for deleted user from DB
     * @param username whose user you want to delete
     */

    @Transactional
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
        log.warn("DELETE USER : " + username);
    }

    /**
     * This method needed for get users from DB
     * @return collection users
     */

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
