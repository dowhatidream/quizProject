package com.quizproject.gameAType;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

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
    public ModelAndView addData(GameAVO gameAVO, GameItemAVO gameItemAVO, ResultVO resultVO) {
        System.out.println("ajax 시작");
        System.out.println(">>>>>> gameAVO: " + gameAVO);
        System.out.println(">>>>>> gameItemAVO: " + gameItemAVO);
        System.out.println(">>>>> resultVO: " + resultVO);

        count += 1;

        gameItemAVO.setCount(count);

        if (count > 1) {
            service.addGameItem(gameItemAVO);
            if(count == 3){
                count = 0;
            }
        } else {
            service.addGame(gameAVO);
            resultVO.setGId(gameAVO.getGId());
            service.addResult(resultVO);
            service.addGameItem(gameItemAVO);
        }

        HashMap<String, Object> result = new HashMap<>();
        result.put("gameAVO", gameAVO);

        ModelAndView model = new ModelAndView("jsonView", result);

        return model;

    }

    @RequestMapping(value = "/gameAType/gameAResult.do")
    public String openResult(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<GameAVO> vo = service.selectList();
        System.out.println(vo);
//
//        System.out.println(vo);

        model.addAttribute("vo", vo);

        return "/gameAType/gameAResult";
    }

    @RequestMapping(value = "/gameAType/playGame.do", method = RequestMethod.GET)
    public String openPlay(@RequestParam int gId, GameItemAVO gameItemAVO, Model model) {

        // game에 대한 제목 및 설명
        GameAVO vo = service.selectGame(gId);
        model.addAttribute("vo", vo);

        // gameitem
        List<GameItemAVO> item_vo = service.selectGameItem(gameItemAVO);
        for (int i = 0; i < item_vo.size(); i++){
            System.out.println(">>>>> " + i + "번째: " + item_vo.get(i));
            model.addAttribute("item_vo"+i, item_vo.get(i));
        }


        return "/gameAType/playGame";
    }



}
