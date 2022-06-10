package com.quizproject.gameAType;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class GameAController {

    private final GameAServiceImpl service;

    static int count; // serial

    @RequestMapping(value = "/gameAType/gameACreate.do")
    public String openCreate(HttpServletRequest request, HttpServletResponse response) {
        return "/gameAType/gameACreate";
    }

    // game 저장
    @RequestMapping(value = "/gameAType/addGame.do")
    public void addGame(GameAVO gameAVO) {
        service.addGame(gameAVO);
    }

    // game, gameItem ajax
    @PostMapping(value = "/gameAType/addMain.ajax")
    public ModelAndView addData(GameAVO gameAVO, GameItemAVO gameItemAVO, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("ajax 시작");
        System.out.println(">>>>>> gameAVO: " + gameAVO);
        System.out.println(">>>>>> gameItemAVO: " + gameItemAVO);

        count += 1;

        gameItemAVO.setCount(count);

        if (count > 1) {
            service.addGameItem(gameItemAVO);
        } else {
            service.addGame(gameAVO);
            service.addGameItem(gameItemAVO);
        }

        HashMap<String, Object> result = new HashMap<>();
        result.put("gameAVO", gameAVO);

        ModelAndView model = new ModelAndView("jsonView", result);

        return model;

    }

    @RequestMapping(value = "/gameAType/gameAResult.do")
    public String openResult(Model model, HttpServletRequest request, HttpServletResponse response) {
        GameAVO vo = service.selectGAME();
        System.out.println(vo);
//
//        System.out.println(vo);

        model.addAttribute("vo", vo);

        return "/gameAType/gameAResult";
    }



}
