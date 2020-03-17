package ru.project.chooselang.api.entities;

import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * This class needed to created VacanciesAnswer object
 * @author skwardlow
 * @version 1.0
 * @see JsonIgnoreProperties
 */

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class VacanciesAnswer {

    /**
     * All vacancies that were received from hh api
     */

    private LinkedList<Vacancy> items;

    /**
     * Number of vacancies found
     */

    private Integer found;

    /**
     * Number of Pages Found
     */

    private Integer pages;

    /**
     * Number of vacancies per page
     */

    private Integer per_page;

    /**
     * Page number
     */

    private Integer page;

    /**
     * Whether to return clusters for a given search
     */

    private String clusters;

    /**
     * Parameters used for this search
     */

    private String arguments;

    /**
     * Link to job posting on the site
     */

    private Object alternate_url;
}
