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
    int number;

    String title;
    String contents;
    String date;
    String modify_day;

    int member_number;
    int view;
    int temp_status;
    int price;
}
