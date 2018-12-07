package egycsegomegbelefer.lyrics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ToplistController {
    @RequestMapping(value={"/toplist"}, method = RequestMethod.GET)
    public ModelAndView toplist() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("toplist");
        return modelAndView;
    }
}
