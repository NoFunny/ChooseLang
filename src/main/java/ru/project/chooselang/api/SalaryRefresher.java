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

/**
 * This class needed to refresh salary in page
 * @author skwardlow
 * @version 1.0
 */

@Slf4j
@Component
public class SalaryRefresher {

    /**
     * Wired salaryServise for DAO interaction
     */

    @Autowired
    SalaryService salaryService;

    /**
     *
     * @param lang
     * @param area
     * @param level
     * @param alias
     * @throws IOException
     */

    public void refreshSalary(String lang, String area, String level, String alias) throws IOException {
        LinkedList<Integer> parsedSalaries = new LinkedList<>();
        int vacanciesCount = getVacanciesCount(lang,area,level);
        int averageSalary = 0;
        if (vacanciesCount>1){
            if(vacanciesCount>90){
                for (int i = 0; i<vacanciesCount/90; i++) {
                    parsedSalaries.add(SalaryParser.getAverageSalaryFromAnswer(RequestHandler.hhVacancyAnswerSalaries(lang,area,level,i,90)));
                    log.info("Parsed Salaries is ------- " + parsedSalaries);
                }
            }
            else {
                parsedSalaries.add(SalaryParser.getAverageSalaryFromAnswer(RequestHandler.hhVacancyAnswerSalaries(lang,area,level,0, vacanciesCount)));
                log.info("LOG = " + parsedSalaries);
            }
            for (int i:parsedSalaries){
                averageSalary+=i;
            }
            averageSalary = averageSalary/parsedSalaries.size();
            log.info("LOG = " + averageSalary);
            if(averageSalary<1){
                averageSalary = -1;
            }

        }
        else {
            averageSalary = -1;
        }

        AvgSalary avgSalary = new AvgSalary(lang,alias,level, Integer.toString(averageSalary));
        log.info("LOG_1= " + avgSalary.toString());
        salaryService.createSalary(avgSalary);

    }

    /**
     *
     * @param lang
     * @param area
     * @param level
     * @return
     */

    public static Integer getVacanciesCount(String lang, String area, String level){
        VacanciesAnswer vacancyAns = null;
        try {
            vacancyAns = RequestHandler.hhVacancyAnswerSalaries(lang,area,level,0,1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(vacancyAns!=null){
            if (vacancyAns.getFound()>=1981){
                vacancyAns.setFound(1981);
            }
        }

        return vacancyAns==null ? -1:vacancyAns.getFound();
    }

}
