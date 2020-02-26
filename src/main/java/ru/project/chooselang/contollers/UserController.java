package ru.project.chooselang.contollers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.project.chooselang.entity.User;
import ru.project.chooselang.services.UserService;
import ru.project.chooselang.utils.SplitURL;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@RestController
public class UserController {
    @Autowired
    UserService userService;


    @RequestMapping(value = "/add_user", produces = MediaType.APPLICATION_JSON_VALUE)
    public Byte add_user(@RequestBody String object) throws UnsupportedEncodingException {
        byte answer = 0;
        ArrayList<String> req = SplitURL.split(object);
        if (req.size() == 5) {
            User user = new User(req.get(0), req.get(1), req.get(2), req.get(3), req.get(4));
            answer = userService.AddUser(user);
            return answer;
        } else {
            return answer;
        }
    }
}
