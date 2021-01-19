package com.dandelion.board.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "member")
@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column(name = "id", nullable = false, unique = true, length = 50)
    private String id;

    @Column(name = "password", nullable = false, length = 100)
    private String pw;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Column(name = "address", nullable = false, length = 150)
    private String address;

    @Column(name = "is_bird", nullable = false)
    private int is_bird;

    @Column(name = "point", nullable = false)
    private int point;
}
