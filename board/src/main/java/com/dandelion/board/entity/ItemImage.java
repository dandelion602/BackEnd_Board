package com.dandelion.board.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Table(name = "item_image")
@Entity
public class ItemImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @ManyToOne
    @JoinColumn(name = "board_number", table = "board")
    private Board boardNumber;

    @Column(name = "image_dir", nullable = false, length = 300)
    private String imageDir;

    @Column(name = "file_name", nullable = false, length = 50)
    private String fileName;

    @Column(name = "format", nullable = false, length = 10)
    private String format;

    @Column(name = "size")
    private int size;

    @Column(name = "order_number", nullable = false)
    private int orderNumber;

    @Column(name = "original_filename", nullable = false, length = 45)
    private String originalFilename;
}
