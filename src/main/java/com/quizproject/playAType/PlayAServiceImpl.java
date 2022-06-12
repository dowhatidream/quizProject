package com.quizproject.playAType;

import com.quizproject.gameAType.ResultVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayAServiceImpl implements PlayAService {

    private final PlayADao playADao;
    private int pid;
    @Override
    public void insertPlay(PlayAVO playAVO) {
        playADao.insertPlay(playAVO);
        pid = playAVO.getPId();
    }

    @Override
    public int insertPlayItem(PlayItemAVO playItemAVO) {
        System.out.println("service..playitem: " + pid);
        playItemAVO.setPId(pid);
        playADao.insertPlayItem(playItemAVO);
        System.out.println(">>>>> service..playItemAVO: " + playItemAVO);

        return 1;
    }

    @Override
    public ResultVO selectResult() {
        return playADao.selectResult(pid);
    }

    @Override
    public void updatePlay() {
        playADao.updatePlay(pid);
    }
}
