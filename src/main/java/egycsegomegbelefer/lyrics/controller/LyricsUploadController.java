package egycsegomegbelefer.lyrics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LyricsUploadController {
    @RequestMapping(value={"/lyricsupload"}, method = RequestMethod.GET)
    public ModelAndView lyricsupload() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("lyricsupload");
        return modelAndView;
    }
}