package ru.project.chooselang.api.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Salary {
    private Integer from;
    private Integer to;
    private Boolean gross;
    private String currency;
}
