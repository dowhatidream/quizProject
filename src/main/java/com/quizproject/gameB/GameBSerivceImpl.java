package com.quizproject.gameB;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class GameBSerivceImpl implements GameBService{
    private final GameBDao gameBDao;

    private final String IS_SUCCEEDED = "isSucceeded";
    private final String YES = "Y";
    private final String NO = "N";
    private final String MSG = "msg";
    private final String RESULT = "result";

    @Override
    public HashMap<String, Object> insertGame(GameVO gameVO) {
        int result = gameBDao.insertGame(gameVO);

        HashMap<String, Object> returnMap = new HashMap<>();
        if (result > 0) {
            returnMap.put(IS_SUCCEEDED, YES);
            returnMap.put(MSG, "게임 삽입 성공");
        }
        else {
            returnMap.put(IS_SUCCEEDED, NO);
            returnMap.put(MSG, "게임 삽입 실패");
        }

        return returnMap;
    }

    @Override
    public HashMap<String, Object> insertGameItem(GameItemVO gameItemVO) {
        int result = gameBDao.insertGameItem(gameItemVO);

        HashMap<String, Object> returnMap = new HashMap<>();
        if (result > 0) {
            returnMap.put(IS_SUCCEEDED, YES);
            returnMap.put(MSG, "게임아이템 삽입 성공");
            returnMap.put(RESULT, result);
        }
        else {
            returnMap.put(IS_SUCCEEDED, NO);
            returnMap.put(MSG, "게임아이템 삽입 실패");
        }

        return returnMap;
    }
}
