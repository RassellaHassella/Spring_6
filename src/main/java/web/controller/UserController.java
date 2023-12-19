package web.controller;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.Service.UserService;
import web.model.User;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String usersPage(Model model) {
        List<User> listUser = userService.getAll();
        model.addAttribute("usersList", listUser);
        return "users";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "user-info";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "user-info";

        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/update")
    public String updateUser(Model model, @RequestParam("id") long id ) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        userService.saveUser(user);
        return "user-info";
    }
    @RequestMapping("/delete")
    public String deleteUser(Model model, @RequestParam("id") long id){
        User user = userService.getUserById(id);
        userService.deleteUser(id);
        return "redirect:/";
    }
}

