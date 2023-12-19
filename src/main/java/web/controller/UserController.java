package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.UserDao;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserDao userDao;
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping()
    public String usersList(Model model){
        model.addAttribute("usersList",userDao.usersList());
        return "index";
    }
    @GetMapping("user/{id}")
    public String show(@PathVariable("id") long id, Model model){
        model.addAttribute("user",userDao.show(id));
        return "show";
    }

}
