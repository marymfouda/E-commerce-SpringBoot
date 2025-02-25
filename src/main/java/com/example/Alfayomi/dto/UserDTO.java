package com.example.Alfayomi.dto;

import com.example.Alfayomi.entity.UserOrder;

import java.util.List;

public record UserDTO(Long id ,
                      String firstName ,
                      String lastName ,
                      String email ,
                      List<UserOrder> userOrder) {
}
