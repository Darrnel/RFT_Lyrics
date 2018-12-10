package egycsegomegbelefer.lyrics.controller;

import egycsegomegbelefer.lyrics.domain.Lyrics;
import egycsegomegbelefer.lyrics.domain.User;
import egycsegomegbelefer.lyrics.service.LyricsService;
import egycsegomegbelefer.lyrics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private LyricsService lyricsService;

    @RequestMapping(value={"/"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        Lyrics lyrics = new Lyrics();
        modelAndView.addObject("lyrics", lyrics);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value={"/index"}, method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", user.getUserName());

        Lyrics lyrics = new Lyrics();
        modelAndView.addObject("lyrics", lyrics);

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    public ModelAndView search(Lyrics lyrics){
        ModelAndView modelAndView = new ModelAndView();
        Lyrics showLyrics = lyricsService.findAuthor(lyrics.getAuthor());

        modelAndView.addObject("author", showLyrics.getAuthor());
        modelAndView.addObject("album", showLyrics.getAlbum());
        modelAndView.addObject("title", showLyrics.getTitle());
        modelAndView.addObject("lyricstext", showLyrics.getLyricstext());

        modelAndView.setViewName("showlyrics");
        return modelAndView;
    }
}
