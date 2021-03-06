package egycsegomegbelefer.lyrics.controller;

import egycsegomegbelefer.lyrics.domain.Lyrics;
import egycsegomegbelefer.lyrics.domain.User;
import egycsegomegbelefer.lyrics.service.LyricsService;
import egycsegomegbelefer.lyrics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RankingController {

    @Autowired
    private UserService userService;

    @Autowired
    private LyricsService lyricsService;

    @RequestMapping(value="/ranking", method = RequestMethod.GET)
    public ModelAndView ranking() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByEmail(auth.getName());
            modelAndView.addObject("userName", user.getUserName());
        }catch (NullPointerException e){}

        Lyrics lyrics = new Lyrics();
        modelAndView.addObject("lyrics", lyrics);

        modelAndView.addObject("users",userService.findTop10user());

        modelAndView.setViewName("ranking");
        return modelAndView;
    }
}
