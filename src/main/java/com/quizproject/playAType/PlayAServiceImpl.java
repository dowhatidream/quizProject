package com.quizproject.playAType;

import com.quizproject.gameAType.ResultVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayAServiceImpl implements PlayAService {

    private final PlayADao playADao;
    @Override
    public void insertPlay(PlayAVO playAVO) {
        playADao.insertPlay(playAVO);
    }

    @Override
    public int insertPlayItem(PlayItemAVO playItemAVO) {
        return playADao.insertPlayItem(playItemAVO);
    }
}
