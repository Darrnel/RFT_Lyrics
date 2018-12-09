package egycsegomegbelefer.lyrics.controller;

import egycsegomegbelefer.lyrics.domain.User;
import egycsegomegbelefer.lyrics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ToplistController {

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/toplist"}, method = RequestMethod.GET)
    public ModelAndView toplist() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByEmail(auth.getName());
            modelAndView.addObject("userName", user.getUserName());
        }catch (NullPointerException e){
            System.out.println(e);
        }

        modelAndView.setViewName("toplist");
        return modelAndView;
    }
}
