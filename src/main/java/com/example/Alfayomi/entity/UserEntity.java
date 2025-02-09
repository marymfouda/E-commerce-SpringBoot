package com.example.Alfayomi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;

import java.util.List;


@Entity
@Getter @Setter
@Builder
@Table(name = "_user")
public class UserEntity {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    private String password;
    @NonNull
    private String city;
    @NonNull
    private String address;
    @NonNull
    private String phone;
    private Role role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<Order> orders;

}
