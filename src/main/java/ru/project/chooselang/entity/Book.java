package ru.project.chooselang.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "book")
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;

    private String name;

    @ManyToMany(mappedBy = "books")
    Set<User> user;

    public Book(String name) {
        this.name = name;
    }


}
