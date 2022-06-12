package com.quizproject.playAType;

import com.quizproject.gameAType.ResultVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlayAMapper {
    void insertPlay(PlayAVO playAVO);
    int insertPlayItem(PlayItemAVO playItemAVO);
    ResultVO selectResult(int pId);
    void updatePlay(int pId);
}
