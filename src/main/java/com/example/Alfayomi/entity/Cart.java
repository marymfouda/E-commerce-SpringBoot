package com.example.Alfayomi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private Long quantity;
    private LocalDate created_at;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private UserEntity user;


    @OneToMany(mappedBy = "cart")
    @JsonManagedReference
    private List<Product> products;

}
