package egycsegomegbelefer.lyrics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @GetMapping("/asd")
    public String indexLoader(){
        return "index";
    }

}
