package com.quizproject.playAType;

import com.quizproject.gameAType.ResultVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PlayADao {

    private final PlayAMapper playAMapper;

    public void insertPlay(PlayAVO playAVO){
        playAMapper.insertPlay(playAVO);
    }

    public int insertPlayItem(PlayItemAVO playItemAVO){
        return playAMapper.insertPlayItem(playItemAVO);
    }
    public ResultVO selectResult(int pId) {
        return playAMapper.selectResult(pId);
    }
}
