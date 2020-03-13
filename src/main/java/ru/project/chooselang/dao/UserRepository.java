package ru.project.chooselang.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.project.chooselang.entity.User;

import javax.transaction.Transactional;

/**
 * DAO repository for User objects
 * @author skwardlow, NoFunny
 * @version 1.0
 * @see CrudRepository
 * @see Repository
 * @see User
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Searching user object in DB by:
     * @param username
     * @return User object
     */

    User findByUsername(String username);

    /**
     * Checking exists of user by:
     * @param email
     * @return
     */

    boolean existsByEmail(String email);

    /**
     * Checking exists of user by:
     * @param username
     * @return
     */

    boolean existsByUsername(String username);

    /**
     * Checking exists of user by:
     * @param username
     * @param email
     * @return
     */

    boolean existsByUsernameAndEmail(String username, String email);

    /**
     * Deleting user object in DB by:
     * @param username
     */

    @Transactional
    void deleteByUsername(String username);
}
