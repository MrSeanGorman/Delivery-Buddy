package deliverybuddy.controllers;

import deliverybuddy.models.user.UserDto;
import deliverybuddy.models.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AuthenticationController {


    @Autowired
    IUserService iUserService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        model.addAttribute("title", "Register");
        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute @Valid UserDto userDto, Errors errors) {

        String password = userDto.getPassword();
        String verPassword = userDto.getVerifyPassword();
        if (password.equals(verPassword)) {
            iUserService.save(userDto);
            return "redirect:/hello";
        }

        return "/register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

}
