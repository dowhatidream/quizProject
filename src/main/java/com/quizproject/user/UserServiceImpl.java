package com.quizproject.user;

import com.quizproject.util.ReturnMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserDao userDao;

    @Override
    public HashMap<String, Object> selectUser(UserVO userVO) {
        UserVO result = userDao.selectUser(userVO);

        HashMap<String, Object> returnMap = new HashMap<>();
        if (result != null) {
            returnMap.put("isSucceeded", "Y");
            returnMap.put("msg", "로그인 성공");
            returnMap.put("result", result);
        }
        else {
            returnMap.put("msg", "로그인 실패");
            returnMap.put("isSucceeded", "N");
        }

        return returnMap;
    }
}
