package ru.project.chooselang.api.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class needed to created Langs object
 * @author skwardlow
 * @version 1.0
 * @see NoArgsConstructor
 * @see AllArgsConstructor
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Langs {

    /**
     * Name langs field
     */

    private String name;

    /**
     * Levels object Langs field
     */

    Levels levels;
}
