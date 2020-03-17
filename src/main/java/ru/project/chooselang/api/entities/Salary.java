package ru.project.chooselang.api.entities;

import lombok.Getter;
import lombok.Setter;

/**
 * This class needed to created Salary object
 * @author skwardlow
 * @version 1.0
 *
 */

@Getter
@Setter
public class Salary {

    /**
     * Lower salary limit Salary field
     */

    private Integer from;

    /**
     * Upper limit of salary
     */

    private Integer to;

    /**
     * Sign that salary is shown before taxes
     */

    private Boolean gross;

    /**
     * In what currency is salary indicated
     */

    private String currency;
}
