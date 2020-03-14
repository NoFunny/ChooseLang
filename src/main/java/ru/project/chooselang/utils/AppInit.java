package ru.project.chooselang.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.project.chooselang.dao.UserRepository;
import ru.project.chooselang.entity.Role;
import ru.project.chooselang.entity.User;

import java.util.Collections;

/**
 * App initialisation class, imports current template and set up a admin password
 *
 * @author skwardlow
 * @version 1.0
 * @see Component
 * @see org.springframework.boot.CommandLineRunner
 */
@Component
public class AppInit implements CommandLineRunner {
    /**
     * Wires user repository for creating new administrator
     */
    @Autowired
    UserRepository userRepository;

    /**
     * Creates password encoding object for admin password
     */
    Md4PasswordEncoder md4PasswordEncoder = new Md4PasswordEncoder();

    /**
     * App init method, creates new admin account if previous expired or not exist
     * Downloads a images for template creating (currently disabled)
     *
     * @param args automatically generated
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        User user = new User
                ("admin", "admin", "admin", "admin",
                        md4PasswordEncoder.encode("qweqweqwe"));
        user.setRoles(Collections.singleton(Role.ADMIN));
        user.setActive(true);
        if (!userRepository.existsByUsername("admin")) {
            userRepository.save(user);
        } else {
            userRepository.deleteByUsername("admin");
            userRepository.save(user);
        }

    }
}