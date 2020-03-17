package ru.project.chooselang.contollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.chooselang.entity.User;
import ru.project.chooselang.services.AdminService;
import ru.project.chooselang.utils.SplitURL;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Admin controller class
 * @author NoFunny
 * @version 1.0
 */

@Slf4j
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    /**
     * This method needed for deleted user from DB
     * @param object contain username
     * @return result deleted user
     * @throws UnsupportedEncodingException
     */

    @RequestMapping(value = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE)
    public byte deleteUser(@RequestBody String object) throws UnsupportedEncodingException {
        ArrayList<String> req = SplitURL.split(object);
        adminService.deleteByUsername(req.get(0));
        return 0;
    }

    /**
     * This method needed for get users from DB
     * @return collection users
     */

    @RequestMapping(value = "/getUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getUsers() {
        log.error(adminService.getUsers().toString());
        return adminService.getUsers();
    }
}
