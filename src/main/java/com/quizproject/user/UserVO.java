package com.quizproject.user;

import com.quizproject.util.ProjectVO;
import lombok.Data;

@Data
public class UserVO extends ProjectVO {
    private String uId;
    private String id;
    private String pw;
    private String name;
    private String firstDt;
    private String lastDt;
}
