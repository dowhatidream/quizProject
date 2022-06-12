package com.quizproject.playAType;

import com.quizproject.gameAType.ResultVO;

public interface PlayAService {
    void insertPlay(PlayAVO playAVO);
    int insertPlayItem(PlayItemAVO playItemAVO);
    ResultVO selectResult();
    void updatePlay();
}
