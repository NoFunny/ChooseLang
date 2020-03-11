package ru.project.chooselang.contollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.project.chooselang.api.ApiHandler;
import ru.project.chooselang.entity.User;
import ru.project.chooselang.services.UserService;
import ru.project.chooselang.utils.SplitURL;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * This class needed for REST-controller for mapping POST user requests to the server
 * @author NoFunny
 * @version 1.0
 */

@Slf4j
@RestController
public class UserController {

    /**
     * Wired userService for DAO interaction
     */
    @Autowired
    UserService userService;

    /**
     * Wired apiHandler for DAO interaction
     */
    @Autowired
    ApiHandler apiHandler;

    /**
     *
     * @param object
     * @return
     * @throws UnsupportedEncodingException
     */

    @RequestMapping(value = "/add_user", method = RequestMethod.POST)
    public Byte add_user(@RequestBody String object) throws UnsupportedEncodingException {
        byte answer = 1;
        ArrayList<String> req = SplitURL.split(object);
        log.warn("Got request ===" + req.toString());
        if (req.size() == 5) {
            User user = new User(req.get(0), req.get(1), req.get(2), req.get(3), req.get(4));
            log.error("User data is ===" + user.toString());
            answer = userService.addUser(user);
            return answer;
        } else {
            return answer;
        }
    }

    /**
     *
     * @throws IOException
     */

    @RequestMapping(value = "/updateSalary", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateSalary() throws IOException {
        apiHandler.refreshSalariesDatabase();
    }

    /**
     *
     * @param object
     * @return
     * @throws IOException
     */

    @RequestMapping(value = "/getSalary", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSalary(@RequestBody String object) throws IOException {
        byte answer = 1;
        ArrayList<String> req = SplitURL.split(object);
        log.warn("Got request ===" + req.toString());

        return apiHandler.returnCityData(req.get(0));
    }

    /**
     *
     * @param object
     * @return
     * @throws UnsupportedEncodingException
     */

    @RequestMapping(value = "/getFullName", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getFullName (@RequestBody String object) throws UnsupportedEncodingException {
        ArrayList<String> req = SplitURL.split(object);
        log.warn("Got request ===" + req.toString());
        return userService.getFullName(req.get(0));

    }
}
