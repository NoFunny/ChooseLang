package ru.project.chooselang.contollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.project.chooselang.api.ApiHandler;
import ru.project.chooselang.dao.UserRepository;
import ru.project.chooselang.entity.User;
import ru.project.chooselang.services.UserService;
import ru.project.chooselang.utils.SplitURL;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
@Slf4j
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ApiHandler apiHandler;

    public UserRepository userRepository;

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

//    @RequestMapping(value = "/log_in", method = RequestMethod.POST)
//    public byte log_in(@RequestBody String object) throws UnsupportedEncodingException {
//        byte answer = 1;
//        ArrayList<String> req = SplitURL.split(object);
//        log.warn("Got request ===" + req.toString());
//        if(req.size() == 2) {
//            User user = new User(req.get(0), req.get(1),"asdasd" ,"asdasd" , "asdasd");
//            log.error("User data is ===" + user.toString());
//            answer = userService.log_in(user);
//            return answer;
//        }else
//            return answer;
//    }


    @RequestMapping(value = "/getSalary", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSalary(@RequestBody String object) throws IOException {
        byte answer = 1;
        ArrayList<String> req = SplitURL.split(object);
        log.warn("Got request ===" + req.toString());
        apiHandler.refreshSalariesDatabase();

        return apiHandler.returnCityData("BSK");

  @RequestMapping(value = "/getFullName", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getFullName(@RequestBody String object) throws UnsupportedEncodingException {
        ArrayList<String> req = SplitURL.split(object);
        log.warn("Got request ===" + req.toString());
        return userService.getFullName(req.get(0));

    }
}
