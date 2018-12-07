package egycsegomegbelefer.lyrics.controller;

import egycsegomegbelefer.lyrics.domain.Rang;
import egycsegomegbelefer.lyrics.domain.User;
import egycsegomegbelefer.lyrics.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        user.setRang(Rang.UJONC);
        modelAndView.addObject("userName", user.getUserName());
        modelAndView.addObject("rang", user.getRang().toString().toLowerCase());
        modelAndView.setViewName("profile");
        return modelAndView;
    }
}
