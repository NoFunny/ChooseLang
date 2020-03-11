package ru.project.chooselang.api.entities;

import lombok.Getter;
import lombok.Setter;

/**
 * This class nedded to created Salary object
 * @author skwardlow
 * @version 1.0
 */

@Getter
@Setter
public class Salary {
    private Integer from;
    private Integer to;
    private Boolean gross;
    private String currency;
}
