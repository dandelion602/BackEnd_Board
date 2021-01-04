package com.dandelion.board.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int NUMBER;

    String TITLE;
    String CONTENTS;
    String DATE;
    String MODIFY_DAY;

    int MEMBER_NUMBER;
    int VIEW;
    int TEMP_STATUS;
    int PRICE;
}
