package ru.project.chooselang.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.project.chooselang.dao.UserRepository;
import ru.project.chooselang.entity.*;

import javax.transaction.Transactional;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public byte AddUser(User user) {
        if(userRepository.existsByEmail(user.getEmail())) {
            System.out.println(user.getEmail());
            return 1;
        }

        if(userRepository.existsByUsername(user.getUsername())) {
            System.out.println(user.getUsername());
            return 2;
        }

        if(userRepository.existsByUsernameAndEmail(user.getUsername(), user.getEmail())) {
            System.out.println("Username = " + user.getUsername() + "||| Email = " + user.getEmail());
            return 3;
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
        return 0;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username = " + username);
        return userRepository.findByUsername(username);
    }
}
