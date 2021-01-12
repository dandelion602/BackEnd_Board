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

    private int board_number;
    String image_dir_number;
    String filename;
    String format;
    int size;
    int order;

}
