package com.example.Alfayomi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true)
    @Size(min = 1 , max = 10 , message = "rate must be between 1 and 10 ")
    private float rating;

    private String review;

    @ManyToOne
    @JoinTable(name = "product_id")
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinTable(name = "user_id")
    @JsonBackReference
    private UserEntity user;
}
