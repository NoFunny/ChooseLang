package ru.project.chooselang.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * This class nedded to created CitySalaries object
 * @author skwardlow
 * @version 1.0
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CitySalaries {
    private String city;
    private List<Langs> langs;
}
