package com.quizproject.gameAType;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GameItemADao {

    private final GameAMapper gameAMapper;

    public void addGameItem(GameItemAVO gameItemAVO){

        System.out.println(">>>>> GameItem1 저장");
        System.out.println(">>>>> gameItemVO: " + gameItemAVO);

        gameAMapper.insertGameItem1(gameItemAVO);
        gameAMapper.insertGameItem2(gameItemAVO);

    }

}
