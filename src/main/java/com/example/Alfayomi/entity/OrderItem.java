package com.example.Alfayomi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id ;
      private int quantity;
      private Double price;
      private Double totalPrice;

    @OneToOne(mappedBy = "orderItem", cascade = CascadeType.ALL)
    private Order order;

    @OneToMany(mappedBy = "orderItem")
    @JsonManagedReference
    private List<Product> products;


}
