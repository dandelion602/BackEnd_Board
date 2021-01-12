package com.dandelion.board.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Columns;

import javax.persistence.*;

//getter 자동 생성
@Getter
//setter 자동생성
@Setter
@Entity
public class Board {

    public Board() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    private String title;
    private String contents;
    private String date;
    private String modify_day;

    private int member_number;
    private int view;
    private int temp_status;
    private int price;
}
