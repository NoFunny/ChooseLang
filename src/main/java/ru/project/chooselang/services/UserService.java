package ru.project.chooselang.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.project.chooselang.dao.UserRepository;
import ru.project.chooselang.entity.*;

import javax.transaction.Transactional;
import java.util.Collections;

/**
 * Salary service class
 * @author skwardlow
 * @version 1.0
 * @see UserDetailsService
 */

@Slf4j
@Service
public class UserService implements UserDetailsService {

    /**
     * Dao user repository
     */

    @Autowired
    private UserRepository userRepository;

    /**
     *
     * @param user
     * @return
     */

    @Transactional
    public byte addUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            log.warn("User with email " + user.getEmail() + " exists");
            return 1;
        }

        if(userRepository.existsByUsername(user.getUsername())) {
            log.warn("User with username " + user.getUsername() + " exists");
            return 2;
        }

        if(userRepository.existsByUsernameAndEmail(user.getUsername(), user.getEmail())) {
            log.warn("User with email and username " + user.getUsername() +" + "+ user.getUsername() + " exists");
            return 3;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        log.error(user.toString() + " added successfully");
        return 0;
    }

    /**
     *
     * @param username
     * @return
     */

    @Transactional
    public User getFullName(String username) {
        User user = new User();
        if(userRepository.existsByUsername(username)) {
            user.setFirstName((userRepository.findByUsername(username)).getFirstName());
            user.setLastName((userRepository.findByUsername(username).getLastName()));
        }else{
            return null;
        }
        return user;
    }

    /**
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username = " + username);
        return userRepository.findByUsername(username);
    }
}
