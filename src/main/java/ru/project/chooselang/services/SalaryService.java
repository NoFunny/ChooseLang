package ru.project.chooselang.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.chooselang.api.entities.AvgSalary;
import ru.project.chooselang.dao.SalaryRepository;

/**
 * Salary service class
 * @author skwardlow
 * @version 1.0
 * @see AvgSalary
 * @see SalaryRepository
 */

@Slf4j
@Service
public class SalaryService {

    /**
     * Dao salary repository
     */

    @Autowired
    private SalaryRepository salaryRepository;

    /**
     * Create salary in DB method
     * @param avgSalary object contain city
     * lang, level programmers and average salary
     */

    public void createSalary(AvgSalary avgSalary) {
        salaryRepository.save(avgSalary);
    }


    /**
     * Deleting salary object in DB method
     */

    public void deleteAllSalaries(){
        salaryRepository.deleteAll();
    }

    /**
     * Find avgSalary method by:
     * @param lang
     * @param city
     * @param lvl
     * @return object AvgSalary
     */

    public AvgSalary findForCity(String lang, String city, String lvl){
        return salaryRepository.findByLangAndCityAndLvl(lang, city, lvl);
    }
}
