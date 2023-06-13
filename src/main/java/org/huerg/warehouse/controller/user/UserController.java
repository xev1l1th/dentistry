package org.huerg.warehouse.controller.user;

import lombok.RequiredArgsConstructor;
import org.huerg.warehouse.data.users.Role;
import org.huerg.warehouse.data.users.User;
import org.huerg.warehouse.service.security.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/registration")
    public String get() {
        return "registration";
    }

    @PostMapping("/registration")
    public String post( @RequestParam String username,
                        @RequestParam String password) {

        User u = userService.findByUsername(username);
        if (u != null) {
            return "redirect:/registration";
        }

        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        user.setRoles(Collections.singleton(Role.USER));
        userService.save(user);
        return "redirect:/login";

    }
}
