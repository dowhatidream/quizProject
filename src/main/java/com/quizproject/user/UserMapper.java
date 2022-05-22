package com.quizproject.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    // 로그인
    UserVO selectUser(UserVO userVO);

}
