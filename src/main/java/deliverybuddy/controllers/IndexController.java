package deliverybuddy.controllers;

import deliverybuddy.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class IndexController extends AbstractBaseController {

    @RequestMapping(value = "/hello")
    public String hello(Model model, Principal principal) {

        User user = userService.findByEmail(principal.getName());
        model.addAttribute("user", user);
        model.addAttribute("title", "Hello Test");

        return "hello";
    }

    @RequestMapping(value = "/")
    public String index(Principal user) {

        if (user == null) {
            return "redirect:/login";
        } else { return "/hello"; }
    }

}
