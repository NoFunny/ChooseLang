package ru.project.chooselang.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.project.chooselang.api.entities.CitySalaries;
import ru.project.chooselang.api.entities.Langs;
import ru.project.chooselang.api.entities.Levels;
import ru.project.chooselang.services.SalaryService;

import java.io.IOException;
import java.util.*;

@Slf4j
@Component
public class ApiHandler {

    private static final List<String> langs = Arrays.asList("Python", "Java", "C", "PHP", "JS", "Ruby", "Objective+C");
    private static final List<String> levels = Arrays.asList("Junior","Middle","Senior");


    @Autowired
    SalaryRefresher salaryRefresher;
    @Autowired
    SalaryService salaryService;

    public void refreshSalariesDatabase() throws IOException {
        HashMap<Integer, String> cities = new HashMap<>();
        salaryService.deleteAllSalaries();
        cities.put(1220,"BSK");
        cities.put(4,"NSK");
        cities.put(3,"EKB");
        cities.put(1,"MSK");
        cities.put(2,"SPB");


        for(Map.Entry<Integer, String> city : cities.entrySet()){
            for (String lang : langs){
                for (String level : levels){
                    salaryRefresher.refreshSalary(lang,city.getKey().toString(),level,city.getValue());
                }
            }
        }
    }

    public String returnCityData(String city) throws JsonProcessingException {
        CitySalaries citySalaries = new CitySalaries();
        citySalaries.setCity(city);
        List<Langs> langsList = new LinkedList<>();
        ObjectMapper om = new ObjectMapper();
        for (String lgs: langs){
            Levels levels = new Levels();
            Langs langsObj = new Langs();
            langsObj.setName(lgs);

            levels.setJunior(salaryService.findForCity(lgs,city,"Junior").getAverageSalary());
            levels.setMiddle(salaryService.findForCity(lgs,city,"Middle").getAverageSalary());
            levels.setSenior(salaryService.findForCity(lgs,city,"Senior").getAverageSalary());

            langsObj.setLevels(levels);
            langsList.add(langsObj);
        }

        citySalaries.setLangs(langsList);
        return om.writeValueAsString(citySalaries);
    }

}
