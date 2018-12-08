package egycsegomegbelefer.lyrics.controller;

import egycsegomegbelefer.lyrics.domain.Lyrics;
import egycsegomegbelefer.lyrics.domain.User;
import egycsegomegbelefer.lyrics.service.LyricsService;
import egycsegomegbelefer.lyrics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;

@Controller
public class LyricsUploadController {

    @Autowired
    private LyricsService lyricsService;

    @Autowired
    private UserService userService;

    @RequestMapping(value={"/lyricsupload"}, method = RequestMethod.GET)
    public ModelAndView lyricsupload() {
        ModelAndView modelAndView = new ModelAndView();;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName",user.getUserName());

        Lyrics lyrics = new Lyrics();
        modelAndView.addObject("lyrics", lyrics);

        modelAndView.setViewName("lyricsupload");
        return modelAndView;
    }




    @RequestMapping(value = "/lyricsupload", method = RequestMethod.POST)
    public ModelAndView createNewLyrics(@Valid Lyrics lyrics, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        boolean lyricsExists = lyricsService.isLyricsExists(lyrics.getAuthor(),lyrics.getTitle());


        if (lyricsExists) {
            bindingResult
                    .rejectValue("title", "error.lyrics",
                            "There is already a lyrics registered with the mentioned author and title");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("lyricsupload");
        } else {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            User user = userService.findUserByEmail(auth.getName());

            lyrics.setUser(user);
            //ITT HATALMAS SZAKMAI SZÓCSATÁT VÍVOTT RICHÁRD ÉS VILMOS. - SZAKMAIFELJEGYZŐ MÁRTON ÚR
            lyricsService.saveLyrics(lyrics);
            modelAndView.addObject("successMessage", "Lyrics has been added to the DB successfully");
            modelAndView.setViewName("lyricsupload");

        }
        return modelAndView;
    }
}