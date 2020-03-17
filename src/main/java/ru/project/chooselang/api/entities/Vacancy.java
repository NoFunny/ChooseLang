package ru.project.chooselang.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * This class needed to created Vacancy object
 * @author skwardlow
 * @version 1.0
 * @see JsonIgnoreProperties
 */

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vacancy {
//    private Integer id;
//    private String description;
//    private String branded_description;
//    private String[] key_skills;
//    private Object schedule;
//    private Boolean accept_handicapped;
//    private Boolean accept_kids;
//    private Object experience;
//    private Object address;
//    private String sort_point_distance;
//    private String code;
//    private Object department;
//    private Object employment;

    /**
     * Salary Vacancy field
     */

    private Salary salary;
//    private Boolean archived;
//    private String name;
//    private Object insider_interview;
//    private Object area;
//    private String created_at;
//    private String published_at;
//    private Object employer;
//    private Object apply_alternate_url;
//    private Boolean response_letter_required;
//    private Object type;
//    private Boolean has_test;
//    private String response_url;
//    private Object test;
//    private String[] specialization;
//    private Object contacts;
//    private Object billing_type;
//    private Boolean allow_messages;
//    private Boolean premium;
//    private String driver_license_types;
//    private Boolean accept_incomplete_resumes;
//    private String url;
//    private String alternate_url;
//    private Object relations;
//    private Object snippet;

}
