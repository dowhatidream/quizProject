package com.quizproject.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping(value="/user/main.do")
    public String main(){
        return "/main";
    }
}
