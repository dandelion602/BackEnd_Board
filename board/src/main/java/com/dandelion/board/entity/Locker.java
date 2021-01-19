package com.dandelion.board.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Table(name = "locker")
@Entity
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column(name = "loc_number", nullable = false)
    private int locNumber;

    @Column(name = "size", nullable = false)
    private int size;

    @Column(name = "is_use", nullable = false)
    private int isUse;

//    @OneToOne
//    @JoinColumn(name = "board_number", table = "board")
//    private Board boardNumber;

    @Column(name = "password", length = 50)
    private String password;

    @Column(name = "input_date")
    private Date inputDate;
}
