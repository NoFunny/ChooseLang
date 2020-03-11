package ru.project.chooselang.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller class
 * @author skwardlow
 * @version 1.0
 */
@Controller
public class WebController {

    /**
     *
     * @return
     */

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    /**
     *
     * @return
     */

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(){
        return "profile";
    }


}
