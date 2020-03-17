package ru.project.chooselang.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class needed to created Levels object
 * @author skwardlow
 * @version 1.0
 * @see NoArgsConstructor
 * @see AllArgsConstructor
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Levels {

    /**
     * Level junior Levels field
     */

    private String junior;

    /**
     * Level middle Levels field
     */

    private String middle;

    /**
     * Level senior Levels field
     */

    private String senior;
}
