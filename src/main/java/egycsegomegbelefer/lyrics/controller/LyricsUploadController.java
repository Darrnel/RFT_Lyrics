package egycsegomegbelefer.lyrics.controller;

import egycsegomegbelefer.lyrics.domain.Lyrics;
import egycsegomegbelefer.lyrics.domain.User;
import egycsegomegbelefer.lyrics.service.LyricsService;
import egycsegomegbelefer.lyrics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class LyricsUploadController {

    @Autowired
    private LyricsService lyricsService;

    @RequestMapping(value={"/lyricsupload"}, method = RequestMethod.GET)
    public ModelAndView lyricsupload() {
        ModelAndView modelAndView = new ModelAndView();
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
            //ITT HATALMAS SZAKMAI SZÓCSATÁT VÍVOTT RICHÁRD ÉS VILMOS. - SZAKMAIFELJEGYZŐ MÁRTON ÚR
            lyricsService.saveLyrics(lyrics);
            modelAndView.addObject("successMessage", "Lyrics has been added to the DB successfully");
            modelAndView.setViewName("lyricsuploader");

        }
        return modelAndView;
    }
}