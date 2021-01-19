package com.dandelion.board.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column(name = "spotLockerNumber")
    private int spotLockerNumber;

    @Column(name = "size")
    private int size;

    @Column(name = "locked")
    private char locked;

    @OneToOne
    @JoinColumn(name = "boardNumber")
    private Board board;

    @Column(name = "password")
    private String password;

    @Column(name = "input_date")
    private Date inputDate;
}
