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

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private LyricsService lyricsService;

    @RequestMapping(value={"/"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByEmail(auth.getName());
            modelAndView.addObject("userName", user.getUserName());
        }catch (NullPointerException e){}

        String activeRadioButton = "author";

        Lyrics lyrics = new Lyrics();
        modelAndView.addObject("lyrics", lyrics);
        modelAndView.addObject("activeRadio", activeRadioButton);

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = {"/search"}, method = RequestMethod.POST)
    public ModelAndView search(Lyrics lyrics){
        ModelAndView modelAndView = new ModelAndView();
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByEmail(auth.getName());
            modelAndView.addObject("userName", user.getUserName());
        }catch (NullPointerException e){}

        String activeRadioButton = lyrics.getActiveRadio();
        String searchText = lyrics.getSearchText();
        List<Lyrics> showLyrics = lyricsService.findAuthor(searchText);

        if(activeRadioButton.equals("author")){
             showLyrics = lyricsService.findAuthor(searchText);
        }
        else if(activeRadioButton.equals("title")){
            showLyrics = lyricsService.findTitle(searchText);        }

        else if(activeRadioButton.equals("lyrics")){
            showLyrics = lyricsService.findLyricstext(searchText);
        }

        modelAndView.addObject("lyricses", showLyrics);

        modelAndView.setViewName("showlyrics");
        return modelAndView;
    }
}
