package ru.project.chooselang.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.project.chooselang.entity.User;

import javax.transaction.Transactional;

/**
 * DAO repository for User objects
 * @author skwardlow
 * @version 1.0
 * @see CrudRepository
 * @see Repository
 * @see User
 */

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     *
     * @param username
     * @return
     */

    User findByUsername(String username);

    /**
     *
     * @param email
     * @return
     */

    boolean existsByEmail(String email);

    /**
     *
     * @param username
     * @return
     */

    boolean existsByUsername(String username);

    /**
     *
     * @param username
     * @param email
     * @return
     */

    boolean existsByUsernameAndEmail(String username, String email);

    /**
     *
     * @param username
     */

    @Transactional
    void deleteByUsername(String username);

}
