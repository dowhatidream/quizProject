package com.quizproject.gameAType;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface GameAMapper {

    void insertGame(GameAVO gameAVO);
//    void insertGameItem1(int count, GameItemAVO gameItemAVO);
    void insertGameItem1(GameItemAVO gameItemAVO);
    void insertGameItem2(GameItemAVO gameItemAVO);
    int selectGID();
    GameAVO selectGAME();
}
