package com.example.Alfayomi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
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

    @NotBlank(message = "email is required")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "password is required")
    private String password;
    @NonNull
    private String city;

    @NotBlank(message = "address is required")
    private String address;

    @NotBlank(message = "Phone is required")
    @Column(unique = true)
    private String phone;

    private Role role;


    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<UserOrder> userOrders;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Rate> rates;
}
