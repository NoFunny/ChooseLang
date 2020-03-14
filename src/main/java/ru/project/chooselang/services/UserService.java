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
import java.util.Collection;
import java.util.Collections;
import java.util.Set;


/**
 * Salary service class
 * @author skwardlow, NoFunny
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
     * Registration user method
     * @param user object to be added
     * @return result registration new User to DB
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
     * Get fullname user method
     * @param username username by object user
     * @return User object
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
     * This method adds a book to a specific user
     * @param nameBook to be added
     * @param username which add a book
     * @return response code
     */

    @Transactional
    public byte addBook(String nameBook, String username) {
        if(userRepository.existsByUsername(username)) {
            User user = userRepository.findByUsername(username);
            Set<Book> newBook= user.getBooks();
            newBook.add(new Book(nameBook));
            user.setBooks(newBook);
            return 0;
        }
        return 1;
    }

    /**
     * This method returned a collection of books by a specific user
     * @param username whose books you need to get
     * @return collection of books by a specific user
     */

    @Transactional
    public Set<Book> getBook(String username) {
        if(userRepository.existsByUsername(username)) {
            User user = userRepository.findByUsername(username);
            return user.getBooks();
        }
        return null;
    }

    /**
     *
     * @param username whose book you want to delete
     * @param nameBook to be deleted
     * @return response code
     */

    @Transactional
    public Byte deleteBook(String username, String nameBook) {
        if(userRepository.existsByUsername(username)) {
            User user = userRepository.findByUsername(username);
            log.error("LOG NAMEBOOOOOK ===== " + nameBook);
            Set<Book> newListBook = getBook(username);
            newListBook.removeIf(prop -> prop.getName().equals(nameBook));
            return 0;
        }
        return 1;
    }

    /**
     * load user by username automatically generated method
     * @param username username by object user
     * @return user object
     * @throws UsernameNotFoundException
     */


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Username = " + username);
        return userRepository.findByUsername(username);
    }
}
