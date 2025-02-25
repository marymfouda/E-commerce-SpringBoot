package com.example.Alfayomi.dto;

import java.util.Set;

public record ProductOrderDTO(String name ,
                              Float price ,
                              Integer inStock ,
                              Set<String> availableRoast,
                              Set<Double> availableWeight ,
                              Integer quantity
                              )
{
}