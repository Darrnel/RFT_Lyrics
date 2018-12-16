package egycsegomegbelefer.lyrics.controller;

import egycsegomegbelefer.lyrics.domain.Lyrics;
import egycsegomegbelefer.lyrics.domain.User;
import egycsegomegbelefer.lyrics.service.LyricsService;
import egycsegomegbelefer.lyrics.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private LyricsService lyricsService;

    @RequestMapping(value="/profile", method = RequestMethod.GET)
    public ModelAndView profile() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("lyricses", lyricsService.findAllLyricsByUserId(user.getId()));
        modelAndView.addObject("user", user);
        modelAndView.addObject("userName", user.getUserName());
        modelAndView.addObject("rang", user.getRang());

        Lyrics lyrics = new Lyrics();
        modelAndView.addObject("lyrics", lyrics);
        modelAndView.setViewName("profile");
        return modelAndView;
    }


    @RequestMapping(value = "/showMyLyrics", method = RequestMethod.POST)
    public ModelAndView showLyrics (Lyrics lyrics){
        ModelAndView modelAndView = new ModelAndView();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", user.getUserName());

        List<Lyrics> showLyrics = lyricsService.findAllLyricsByUserId(user.getId());
        modelAndView.addObject("lyricses",  showLyrics);

        modelAndView.setViewName("showlyrics");

        return modelAndView;
    }

}
