package deliverybuddy.controllers;

import deliverybuddy.models.user.EmailExistsException;
import deliverybuddy.models.user.UserDto;
import deliverybuddy.models.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class AuthenticationController extends AbstractBaseController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute(new UserDto());
        model.addAttribute("title", "Register");
        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute @Valid UserDto userDto, Errors errors) {

        try {
            userService.save(userDto);
        } catch (EmailExistsException emailExistsException) {
            errors.rejectValue("email", "email.alreadyexists", emailExistsException.getMessage());
            return "register";
        }
        return "redirect:/hello";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, Principal principal) {

        if (principal != null) {
            return "redirect:/hello";
        }

        model.addAttribute("title", "Log In");
        return "login";
    }
}
