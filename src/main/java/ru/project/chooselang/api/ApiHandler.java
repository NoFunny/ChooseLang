package ru.project.chooselang.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Slf4j
@Component
public class ApiHandler {

    public static void refreshSalariesDatabase(){
        HashMap<String, Integer> cities = new HashMap<>();
        cities.put("BSK",1220);
        cities.put("NSK",4);
        cities.put("EKB",3);
        cities.put("MSK",1);
        cities.put("SPB",2);
        SalaryRefresher.refreshSalary("Python",cities.get("NSK"),"Junior","NSK");
    }

}
