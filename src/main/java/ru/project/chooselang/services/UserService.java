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
@Slf4j
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

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

    @Transactional
    public Byte log_in(User user) {
        if(!userRepository.existsByUsername(user.getUsername())) {
            return 1;
        }
        return 0;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username = " + username);
        return userRepository.findByUsername(username);
    }
}
