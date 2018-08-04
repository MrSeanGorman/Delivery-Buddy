package deliverybuddy.controllers;

import deliverybuddy.models.User;
import deliverybuddy.models.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.security.Principal;

public class AbstractBaseController {

    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public User loggedInUser(Principal principal) {
        if (principal != null)
            return userService.findByEmail(principal.getName());
        return null;
    }
}
