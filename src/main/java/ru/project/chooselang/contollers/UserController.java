package ru.project.chooselang.contollers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.project.chooselang.entity.Book;
import ru.project.chooselang.api.ApiHandler;
import ru.project.chooselang.entity.User;
import ru.project.chooselang.services.UserService;
import ru.project.chooselang.utils.SplitURL;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Set;

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
     * Registration method for creating a new user
     * @param object contain username, firstname, lastname,
     * email, password.
     * @return result registration new user
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
     * Update salary DB method
     * @throws IOException
     */

    @RequestMapping(value = "/updateSalary", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateSalary() throws IOException {
        apiHandler.refreshSalariesDatabase();
    }

    /**
     * Get Salary from DB method
     * @param object contain city
     * @return JSON object whit all salaries by city
     * @throws IOException
     */

    @RequestMapping(value = "/getSalary", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String getSalary(@RequestBody String object) throws IOException {
        ArrayList<String> req = SplitURL.split(object);
        log.warn("Got request ===" + req.toString());
        return apiHandler.returnCityData(req.get(0));
    }

    /**
     * Get fullname user from DB method
     * @param object contain username
     * @return Object user
     * @throws UnsupportedEncodingException
     */

    @RequestMapping(value = "/getFullName", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getFullName (@RequestBody String object) throws UnsupportedEncodingException {
        ArrayList<String> req = SplitURL.split(object);
        log.warn("Got request ===" + req.toString());
        return userService.getFullName(req.get(0));

    }

    /**
     * This method needed for adding a new book to the user in the library
     * @param object contain nameBook and username
     * @return response code
     * @throws UnsupportedEncodingException
     */

    @RequestMapping(value = "/add_book", produces = MediaType.APPLICATION_JSON_VALUE)
    public byte addBook(@RequestBody String object) throws UnsupportedEncodingException {
        ArrayList<String> req = SplitURL.split(object);
        log.info("Got request === " + req.get(0));
        log.info("Got request2 === " + req.get(1));
        byte answer = 1;
        answer = userService.addBook(req.get(0),req.get(1));
        return answer;
    }

    /**
     * This method needed for return user book collection
     * @param object contain username
     * @return user book collection
     * @throws UnsupportedEncodingException
     */

    @RequestMapping(value = "/get_book", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<Book> getBook(@RequestBody String object) throws UnsupportedEncodingException {
        ArrayList<String> req = SplitURL.split(object);
        return userService.getBook(req.get(0));
    }

    /**
     * This method deletes a book from a user by name
     * @param object contain username and nameBook
     * @return response code
     * @throws UnsupportedEncodingException
     */

    @RequestMapping(value = "/deleteBook", produces = MediaType.APPLICATION_JSON_VALUE)
    public Byte deleteBook(@RequestBody String object) throws UnsupportedEncodingException {
        ArrayList<String> req = SplitURL.split(object);
        return userService.deleteBook(req.get(0), req.get(1));
    }
}
