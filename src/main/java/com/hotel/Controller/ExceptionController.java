package com.hotel.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionController {

    @GetMapping("/accessDenied")
    public String accessDenied(){
        return "accessDenied";
    }
}
