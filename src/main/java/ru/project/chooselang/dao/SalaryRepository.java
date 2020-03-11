package ru.project.chooselang.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.project.chooselang.api.entities.AvgSalary;


@Repository
public interface SalaryRepository extends CrudRepository<AvgSalary,Long> {
    boolean existsByLangAndCityAndLvl(String lang, String city, String lvl);
    AvgSalary findByLangAndCityAndLvl(String lang, String city, String lvl);
}
