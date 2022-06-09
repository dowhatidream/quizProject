package com.quizproject.gameB;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class GameBController {

    private final GameBService gameBService;

    @RequestMapping(value = "/gameB/game.do")
    public String game(){
        return "/gameB/game";
    }

    @RequestMapping(value = "/gameB/gameItem.do")
    public String gameItem(@RequestParam String gId, Model model, HttpServletRequest request){
        System.out.println("겜아이디:: " + gId);
        model.addAttribute("gId", gId);

        return "/gameB/gameItem";
    }

    @PostMapping(value = "/gameB/insertGame.ajax")
    public ModelAndView insertGame(GameVO paramVO, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String uID = (String) session.getAttribute("uId");
        paramVO.setUId(uID);

        System.out.println("준비::: " + paramVO);
        HashMap<String, Object> resultMap = gameBService.insertGame(paramVO);
        resultMap.put("gId", paramVO.getGId());
        System.out.println("결과::: " + resultMap);
        System.out.println("결과2::: " + paramVO.getGId());

        //model.addAttribute("gId", paramVO.getGId());

        ModelAndView modelAndView = new ModelAndView("jsonView", resultMap);
        return modelAndView;
    }

    @PostMapping(value = "/gameB/insertGameItem.ajax")
    public ModelAndView insertGameItem(GameItemVO paramVO, HttpServletRequest request) {

        HashMap<String, Object> resultMap = gameBService.insertGameItem(paramVO);
        //GameItemVO resultVO = (GameItemVO) resultMap.get("result");
        System.out.println("결과::: " + resultMap.toString());

        ModelAndView model = new ModelAndView("jsonView", resultMap);
        return model;
    }
}
