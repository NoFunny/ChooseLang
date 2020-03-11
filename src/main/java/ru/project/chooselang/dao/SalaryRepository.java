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
     *
     * @param lang
     * @param city
     * @param lvl
     * @return
     */

    boolean existsByLangAndCityAndLvl(String lang, String city, String lvl);

    /**
     *
     * @param lang
     * @param city
     * @param lvl
     * @return
     */

    AvgSalary findByLangAndCityAndLvl(String lang, String city, String lvl);
}
