package ru.project.chooselang.api.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * This class needed to created AvgSalary entity
 * @author skwardlow
 * @version 1.0
 * @see Entity
 * @see Table
 * @see NoArgsConstructor
 */

@Getter
@Setter
@Entity
@Table(name = "slr")
@NoArgsConstructor
public class AvgSalary {

    /**
     * An id field for DB identification, automatically generated by db
     *
     * @see Id
     * @see GeneratedValue
     */

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    /**
     * City AvgSalary field
     */

    private String city;

    /**
     * Lang AvgSalary field
     */

    private String lang;

    /**
     * Level AvgSalary field
     */

    private String lvl;

    /**
     * Average salary AvgSalary field
     */

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
