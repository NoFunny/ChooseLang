package ru.project.chooselang.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * This class needed to created CitySalaries object
 * @author skwardlow
 * @version 1.0
 * @see NoArgsConstructor
 * @see AllArgsConstructor
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CitySalaries {

    /**
     * City CitySalaries field
     */

    private String city;

    /**
     * Langs collection CitySalaries field
     */

    private List<Langs> langs;
}
