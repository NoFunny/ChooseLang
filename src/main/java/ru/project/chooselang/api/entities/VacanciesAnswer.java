package ru.project.chooselang.api.entities;

import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * This class nedded to created VacanciesAnswer object
 * @author skwardlow
 * @version 1.0
 */

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VacanciesAnswer {
    private LinkedList<Vacancy> items;
    private Integer found;
    private Integer pages;
    private Integer per_page;
    private Integer page;
    private String clusters;
    private String arguments;
    private Object alternate_url;
}
