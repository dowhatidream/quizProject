package com.quizproject.user;

import java.util.HashMap;

public interface UserService {
    // 로그인
    HashMap<String, Object> selectUser(UserVO userVO);
}
