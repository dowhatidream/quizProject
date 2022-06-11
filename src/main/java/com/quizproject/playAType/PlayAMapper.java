package com.quizproject.playAType;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlayAMapper {
    void insertPlay(PlayAVO playAVO);
    int insertPlayItem(PlayItemAVO playItemAVO);
}
