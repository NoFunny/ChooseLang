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
import ru.project.chooselang.dao.UserRepository;
import ru.project.chooselang.entity.Book;
import ru.project.chooselang.entity.User;
import ru.project.chooselang.services.UserService;
import ru.project.chooselang.utils.SplitURL;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

@Slf4j
@RestController
public class UserController {
    @Autowired
    UserService userService;

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

    @RequestMapping(value = "/getFullName", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getFullName(@RequestBody String object) throws UnsupportedEncodingException {
        ArrayList<String> req = SplitURL.split(object);
        log.warn("Got request ===" + req.toString());
        return userService.getFullName(req.get(0));
    }

    @RequestMapping(value = "/add_book", produces = MediaType.APPLICATION_JSON_VALUE)
    public byte addBook(@RequestBody String object) throws UnsupportedEncodingException {
        ArrayList<String> req = SplitURL.split(object);
        log.info("Got request === " + req.get(0));
        log.info("Got request2 === " + req.get(1));
        byte answer = 1;
        answer = userService.addBook(req.get(0),req.get(1));
        return answer;
    }

    @RequestMapping(value = "/get_book", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Book> getBook(@RequestBody String object) throws UnsupportedEncodingException {
        ArrayList<String> req = SplitURL.split(object);
        return userService.getBook(req.get(0));
    }
}
