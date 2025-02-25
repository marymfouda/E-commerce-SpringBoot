package com.example.Alfayomi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id ;
      private Float price;
      private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "userOrder_id" , nullable = false)
    @JsonBackReference
    private UserOrder userOrder;

    @ManyToOne
    @JoinColumn(name = "product_id" , nullable = false)
    @JsonBackReference
    private Product product;
}
