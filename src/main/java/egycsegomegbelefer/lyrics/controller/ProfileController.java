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
        System.out.println(auth.getPrincipal());
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("lyricses", lyricsService.findAllLyricsByUserId(user.getId()));
        modelAndView.addObject("userName", user.getUserName());
        modelAndView.addObject("rang", user.getRang());

        Lyrics lyrics = new Lyrics();
        modelAndView.addObject("lyrics", lyrics);

        modelAndView.setViewName("profile");
        return modelAndView;
    }


    @RequestMapping(value = "/showlyrics", method = RequestMethod.POST)
    public ModelAndView showLyrics (@Valid Lyrics lyrics){
        ModelAndView modelAndView = new ModelAndView();

        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByEmail(auth.getName());
            modelAndView.addObject("userName", user.getUserName());
        }catch (NullPointerException e){}

        Lyrics showLyrics = lyricsService.findLyricsByLyricsId(lyrics.getId());

        System.out.println("!!! HALO HALO TESZT TESZT TESZT HALO !!!" + showLyrics.getId() + showLyrics.getAuthor() + showLyrics.getAlbum() + showLyrics.getTitle() + showLyrics.getLyricstext());
        modelAndView.addObject("id", showLyrics.getId());
        modelAndView.addObject("author", showLyrics.getAuthor());
        modelAndView.addObject("album", showLyrics.getAlbum());
        modelAndView.addObject("title", showLyrics.getTitle());
        modelAndView.addObject("lyricstext", showLyrics.getLyricstext());
        System.out.println("!!! HALO HALO TESZT TESZT TESZT HALO !!!" + showLyrics.getId() + showLyrics.getAuthor() + showLyrics.getAlbum() + showLyrics.getTitle() + showLyrics.getLyricstext());

        modelAndView.setViewName("showlyrics");

        return modelAndView;

    }

}
