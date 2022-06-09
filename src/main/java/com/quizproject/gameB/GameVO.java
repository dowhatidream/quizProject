package com.quizproject.gameB;

import lombok.Data;

@Data
public class GameVO {
    private int gId;
    private String title;
    private String intro;
    private String thumbnail;
    private String type;
    private String uId;
    private String firstDt;
    private String lastDt;
}
