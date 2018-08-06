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
        model.addAttribute("title", "Hello Test");
        model.addAttribute("user", user);

        return "hello";
    }

    @RequestMapping(value = "/")
    public String index(Principal principal) {

/*        if (principal == null) {
            return "redirect:/login";
        } else { */return "redirect:/hello"; /*}*/
    }

}
