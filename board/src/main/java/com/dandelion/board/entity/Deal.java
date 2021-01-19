package com.dandelion.board.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Table(name = "deal")
@Entity
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @OneToOne
    @JoinColumn(name = "board_number", nullable = false)
    private Board boardNumber;

    @ManyToOne
    @JoinColumn(name = "seller_number", nullable = false)
    private Member sellerNumber;

    @ManyToOne
    @JoinColumn(name = "buyer_number", nullable = true)
    private Member buyerNumber;

    @ManyToOne
    @JoinColumn(name = "bird_number")
    private Member birdNumber;

    @ManyToOne
    @JoinColumn(name = "locker_number", nullable = true)
    private Locker lockerNumber;

    @Column(name = "receiving_date")
    private Date receivingDate;

    @Column(name = "shipping_date")
    private Date shippingDate;

    @Column(name = "delivery_date")
    private Date deliveryDate;

    @Column(name = "is_pickup", nullable = false)
    private int isPickup = 0;

    @Column(name = "temp_status", nullable = false)
    private int tempStatus;

}
