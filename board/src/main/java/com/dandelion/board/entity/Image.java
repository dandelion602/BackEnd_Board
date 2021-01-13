package com.dandelion.board.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Image {

    public Image() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @ManyToOne
    @JoinColumn(name = "board_number")
    private Board board;

    private String fileName;
    private String imageDirNumber;
    private int size;
}
