package ru.project.chooselang.api.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "slr")
@NoArgsConstructor
public class AvgSalary {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String city;
    private String lang;
    private String lvl;
    private String averageSalary;


    public AvgSalary(String lang, String city, String lvl, String averageSalary){
        this.lang = lang;
        this.city = city;
        this.lvl = lvl ;
        this.averageSalary = averageSalary;
    }

}
