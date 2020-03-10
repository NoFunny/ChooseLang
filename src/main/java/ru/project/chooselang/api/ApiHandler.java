package ru.project.chooselang.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

@Slf4j
@Component
public class ApiHandler {
    @Autowired
    SalaryRefresher salaryRefresher;

    public void refreshSalariesDatabase() throws IOException {
        HashMap<String, Integer> cities = new HashMap<>();
        cities.put("BSK",1220);
        cities.put("NSK",4);
        cities.put("EKB",3);
        cities.put("MSK",1);
        cities.put("SPB",2);
        salaryRefresher.refreshSalary("Python", "4","Junior","NSK");
    }
}
