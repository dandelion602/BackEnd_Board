package com.dandelion.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//getter 자동 생성
@Getter
//setter 자동생성
@Setter
@Entity
public class Board {

    public Board() {
    }

    @Id
    @GeneratedValue()
    int NUMBER;

    String TITLE;
    String CONTENTS;
    String DATE;
    String MODIFY_DAY;

    int MEMBER_NUMBER;
    int VIEW;
    int TEMP_STATUS;
    int PRICE;

    @Builder
    public Board(int NUMBER, String TITLE, String CONTENTS, String DATE, String MODIFY_DAY, int MEMBER_NUMBER, int VIEW, int TEMP_STATUS, int PRICE) {
        this.TITLE = TITLE;
        this.CONTENTS = CONTENTS;
        this.DATE = DATE;
        this.MODIFY_DAY = MODIFY_DAY;
        this.MEMBER_NUMBER = MEMBER_NUMBER;
        this.VIEW = VIEW;
        this.TEMP_STATUS = TEMP_STATUS;
        this.PRICE = PRICE;
    }
}
