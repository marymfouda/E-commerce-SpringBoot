package com.example.Alfayomi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "OrderEntity")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Double subtotal;
    private Double discount;
    private Double deliveryFee;
    private Double total;
    private String promoCode;

    @ManyToOne
    @JoinTable(name = "user_id")
    @JsonBackReference
    private UserEntity user;

    @OneToOne
    @JoinColumn(name = "orderItem_id", unique = true, nullable = false)
    private OrderItem orderItem;


}
