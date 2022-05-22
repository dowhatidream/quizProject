package com.quizproject.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDao {
    private final UserMapper userMapper;

    // 로그인
    public UserVO selectUser(UserVO userVO){
        return userMapper.selectUser(userVO);
    }
}
