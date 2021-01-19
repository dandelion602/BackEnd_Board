package com.dandelion.board.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Getter
@Setter
@Table(name = "board")
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "member_number", nullable = false)
    public Member member;

    @Column(name = "view", nullable = false)
    private int view;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @Column(name = "modify_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    @Column(name = "contents", length = 5000)
    private String contents;

    @Column(name = "status", nullable = false)
    private int status;

    @Column(name = "price", nullable = false)
    private int price;


    // --FK--
    @OneToMany
    @JoinColumn(name = "board_number", table = "item_image")
    public Collection<ItemImage> itemImages;


}
