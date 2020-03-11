package ru.project.chooselang.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.chooselang.api.entities.AvgSalary;
import ru.project.chooselang.api.entities.Salary;
import ru.project.chooselang.dao.SalaryRepository;
import ru.project.chooselang.dao.UserRepository;

@Slf4j
@Service
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;

    public boolean checkSalary(String lang, String area, String lvl){
        return salaryRepository.existsByLangAndCityAndLvl(lang,area,lvl);
    }

    public void createSalary(AvgSalary avgSalary) {
        salaryRepository.save(avgSalary);
    }

    public void deleteAllSalaries(){
        salaryRepository.deleteAll();
    }

    public AvgSalary findForCity(String lang, String city, String lvl){
        return salaryRepository.findByLangAndCityAndLvl(lang, city, lvl);
    }
}
