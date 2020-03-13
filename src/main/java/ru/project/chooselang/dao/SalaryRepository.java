package ru.project.chooselang.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.project.chooselang.api.entities.AvgSalary;

/**
 * DAO repository for Salary objects
 * @author skwardlow
 * @version 1.0
 * @see CrudRepository
 * @see Repository
 * @see AvgSalary
 */

@Repository
public interface SalaryRepository extends CrudRepository<AvgSalary,Long> {

    /**
     * Checking exists of salary by:
     * @param lang
     * @param city
     * @param lvl
     * @return true or false one or another AvgSalary
     * depending on the transferred lang, city and level programming
     */

    boolean existsByLangAndCityAndLvl(String lang, String city, String lvl);

    /**
     * Searching Salary object in DB by:
     * @param lang
     * @param city
     * @param lvl
     * @return AvgSalary object
     */

    AvgSalary findByLangAndCityAndLvl(String lang, String city, String lvl);
}
