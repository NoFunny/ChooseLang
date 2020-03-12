package ru.project.chooselang.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    private String name;

    /**
     * Constructor for Book object
     * @param name
     */

    Book(String name) {
        this.name = name;
    }


}
