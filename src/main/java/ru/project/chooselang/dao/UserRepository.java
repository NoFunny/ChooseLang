package ru.project.chooselang.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.project.chooselang.entity.User;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByUsernameAndEmail(String username, String email);

    @Transactional
    void deleteByUsername(String username);

}
