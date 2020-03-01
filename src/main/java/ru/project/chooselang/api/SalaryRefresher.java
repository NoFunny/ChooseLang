package ru.project.chooselang.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.project.chooselang.api.entities.VacanciesAnswer;

import java.io.IOException;

@Slf4j
@Component
public class SalaryRefresher {
    public static void refreshSalary(String lang, Integer area, String level){


    }




    public static Integer getVacanciesCount(String lang, String area, String level){
        VacanciesAnswer vacancyAns = null;
        try {
            vacancyAns = RequestHandler.hhVacancyAnswerSalaries(lang,area,level,0,1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vacancyAns==null ? -1:vacancyAns.getFound();
    }

}
