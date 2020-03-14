package ru.project.chooselang.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.chooselang.dao.UserRepository;
import ru.project.chooselang.entity.User;

import javax.transaction.Transactional;


@Slf4j
@Service
public class AdminService  {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
        log.warn("DELETE USER : " + username);
    }

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
}
