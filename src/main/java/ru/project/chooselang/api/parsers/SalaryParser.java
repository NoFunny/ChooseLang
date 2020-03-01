package ru.project.chooselang.api.parsers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.project.chooselang.api.entities.VacanciesAnswer;
import ru.project.chooselang.api.entities.Vacancy;

import java.util.LinkedList;
import java.util.List;

@Slf4j
@Component
public class SalaryParser {
    public static Integer getAverageSalaryFromAnswer(VacanciesAnswer vacanciesAnswer){
        int averageSalaryFromPage=0;
        List<Integer> parsedsalaries = new LinkedList<>();
        for (Vacancy vacancy:vacanciesAnswer.getVacancies()){
            if (vacancy.getSalary()!=null){
                if (vacancy.getSalary().getFrom()!=null){
                    switch (vacancy.getSalary().getCurrency()){
                        case "AZN":
                            parsedsalaries.add(vacancy.getSalary().getFrom()*36);
                            break;
                        case "BYR":
                            parsedsalaries.add(vacancy.getSalary().getFrom()*29);
                            break;
                        case "EUR":
                            parsedsalaries.add(vacancy.getSalary().getFrom()*73);
                            break;
                        case "GEL":
                            parsedsalaries.add(vacancy.getSalary().getFrom()*23);
                            break;
                        case "KGS":
                            parsedsalaries.add(vacancy.getSalary().getFrom()/5);
                            break;
                        case "KZT":
                            parsedsalaries.add(vacancy.getSalary().getFrom());
                            break;
                        case "RUR":
                            parsedsalaries.add(vacancy.getSalary().getFrom()*3);
                            break;
                        case "USD":
                            parsedsalaries.add(vacancy.getSalary().getFrom()*66);
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        for (Integer parsedsalary : parsedsalaries) {
            averageSalaryFromPage += parsedsalary;
        }
        return averageSalaryFromPage;
    }
}
