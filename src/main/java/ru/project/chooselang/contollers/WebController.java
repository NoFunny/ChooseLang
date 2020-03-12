package ru.project.chooselang.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller class
 * @author skwardlow, NoFunny
 * @version 1.0
 */
@Controller
public class WebController {

    /**
     * Mapping for index page method
     * @return index page
     */

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    /**
     * Mapping for profile page method
     * @return profile page
     */

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(){
        return "profile";
    }


}
