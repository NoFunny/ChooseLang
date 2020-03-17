package ru.project.chooselang.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

/**
 * Book representation class
 * @author NoFunny
 * @version 1.0
 * @see Table
 * @see NoArgsConstructor
 * @see Entity
 */

@Getter
@Setter
@Entity
@Table(name = "book")
@NoArgsConstructor
public class Book {

    /**
     * An id field for DB identification, automatically generated by db
     *
     * @see Id
     * @see GeneratedValue
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    /**
     * Book name field
     */

    private String name;

    /**
     * Book user field for bind user collections to a book
     */

    @ManyToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "u_books")
    Set<User> user;

    /**
     * Constructor for Book object
     * @param name book
     */

    public Book(String name) {
        this.name = name;
    }


}
