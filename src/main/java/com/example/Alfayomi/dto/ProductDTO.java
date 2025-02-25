package com.example.Alfayomi.dto;

import lombok.Builder;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Builder
public record ProductDTO(
         String name ,
         String description,
         Float price,
         Integer stock,
         List<MultipartFile> productImages
) {
}
