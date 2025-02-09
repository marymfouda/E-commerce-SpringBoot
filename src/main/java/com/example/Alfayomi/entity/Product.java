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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;
    private String description;
    private Double salary;
    private Double rate;
    private Boolean stock;

    @ManyToOne
    @JoinTable(name = "cart_id")
    @JsonBackReference
    private Cart cart;

    @ManyToOne
    @JoinTable(name = "categories_id")
    @JsonBackReference
    private Categories categories;

    @ManyToOne
    @JoinTable(name = "orderItem_id")
    @JsonBackReference
    private OrderItem orderItem;
}
