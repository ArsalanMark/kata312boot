package spring_boot.kata312_2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring_boot.kata312_2.model.User;
import spring_boot.kata312_2.service.UserService;


import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value="/users")
    public String mainPage(Model model) {
        List<User> users = userService.userList();
        model.addAttribute("users", users);
        return "users";
    }
    @GetMapping(value="/add")
    public String addUser(@ModelAttribute("user") User user) {
        System.out.println("addUser");
        return "save-user";
    }
    @PostMapping("/save")
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }
    @PostMapping("/edit")
    public String editUser(@RequestParam("id") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "save-user";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
