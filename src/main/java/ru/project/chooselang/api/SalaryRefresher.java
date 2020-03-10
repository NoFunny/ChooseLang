package ru.project.chooselang.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.chooselang.api.entities.AvgSalary;
import ru.project.chooselang.api.entities.VacanciesAnswer;
import ru.project.chooselang.api.parsers.SalaryParser;
import ru.project.chooselang.services.SalaryService;

import java.io.IOException;
import java.util.LinkedList;

@Slf4j
@Component
public class SalaryRefresher {


    public static void refreshSalary(String lang, String area, String level, String alias) throws IOException {
        LinkedList<Integer> parsedSalaries = new LinkedList<>();
        int vacanciesCount = getVacanciesCount(lang,area,level);
        int averageSalary = 0;
        SalaryService salaryService = new SalaryService();

        for (int i = 0; i<vacanciesCount/90; i++) {
            parsedSalaries.add(SalaryParser.getAverageSalaryFromAnswer(RequestHandler.hhVacancyAnswerSalaries(lang,area,level,i,90)));
        }
        for (int i:parsedSalaries){
            averageSalary+=i;
        }
        averageSalary = averageSalary/parsedSalaries.size();

        if(salaryService.checkSalary(lang,area,level)){

        }

        AvgSalary avgSalary = new AvgSalary(lang,alias,level, Integer.toString(averageSalary));
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
