package com.example.Alfayomi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column (nullable = false)
    private Double subtotal;
    private LocalDateTime orderDate;
    private Double deliveryFee;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    @JsonBackReference
    private UserEntity user;

    @OneToMany(mappedBy = "userOrder" , cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderItem> orderItem;

    @OneToMany(mappedBy = "userOrder" , cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PromoCode> promoCodes;
}
