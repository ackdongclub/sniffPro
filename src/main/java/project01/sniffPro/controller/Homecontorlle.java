package project01.sniffPro.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class Homecontorlle {

    @RequestMapping("/")
    public String Home() {
        log.info("home controller");
        return "home";
    }

}
