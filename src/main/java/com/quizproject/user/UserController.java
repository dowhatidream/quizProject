package com.quizproject.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping(value="/user/main.do")
    public String main(HttpServletRequest request, HttpServletResponse response){
        return "/main";
    }

    @RequestMapping(value="/user/login.do")
    public String login(HttpServletRequest request, HttpServletResponse response){
        return "/user/login";
    }


    @PostMapping(value = "/user/selectUser.ajax")
    public ModelAndView selectUser(UserVO userVO, HttpServletRequest request, HttpServletResponse response){
        System.out.println("로그인 시작");

        HashMap<String, Object> resultMap = userService.selectUser(userVO);
        String isSucceeded = (String) resultMap.get("isSucceeded");
        UserVO user = (UserVO) resultMap.get("result");
        if (isSucceeded.equals("Y")) {
            HttpSession session = request.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("uId", user.getUId());
        }
        else {

        }
        System.out.println("로그인 끝:: " + resultMap.toString());

        ModelAndView model = new ModelAndView("jsonView", resultMap);

        return model;
    }
}
