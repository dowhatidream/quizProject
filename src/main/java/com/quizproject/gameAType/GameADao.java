package com.quizproject.gameAType;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GameADao {

    private final GameAMapper gameAMapper;
    // gid
    static int gId;

    public int selectGID(){
        return gameAMapper.selectGID();
    }

    public void addGame(GameAVO gameAVO) {
        gameAMapper.insertGame(gameAVO);
    }

    public GameAVO selectGAME(){
        return gameAMapper.selectGAME();
    }


}
