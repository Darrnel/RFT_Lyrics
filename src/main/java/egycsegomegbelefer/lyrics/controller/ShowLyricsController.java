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

import javax.validation.Valid;

@Controller
public class ShowLyricsController {

    @Autowired
    private UserService userService;

    @Autowired
    private LyricsService lyricsService;

    @RequestMapping(value={"/showlyrics"}, method = RequestMethod.GET)
    public ModelAndView showlyrics(@Valid Lyrics lyrics) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByEmail(auth.getName());
            modelAndView.addObject("userName", user.getUserName());
        }catch (NullPointerException e){ }

        //lyrics-list-test
        Lyrics showLyrics = lyricsService.findLyricsByLyricsId(lyrics.getId());

        modelAndView.addObject("author", showLyrics.getAuthor());
        modelAndView.addObject("album", showLyrics.getAlbum());
        modelAndView.addObject("title", showLyrics.getTitle());
        modelAndView.addObject("lyricstext", showLyrics.getLyricstext());
        modelAndView.setViewName("showlyrics");
        return modelAndView;
    }
}