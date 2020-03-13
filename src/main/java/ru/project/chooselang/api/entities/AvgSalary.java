package ru.project.chooselang.api.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * This class nedded to created AvgSalary entity
 * @author skwardlow
 * @version 1.0
 */
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

    /**
     * Constructor AvgSalary object
     * @param lang
     * @param city
     * @param lvl
     * @param averageSalary
     */
    public AvgSalary(String lang, String city, String lvl, String averageSalary){
        this.lang = lang;
        this.city = city;
        this.lvl = lvl ;
        this.averageSalary = averageSalary;
    }

}
