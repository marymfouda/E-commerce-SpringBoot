package com.example.Alfayomi.entity;

import com.example.Alfayomi.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;

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

    @Column(nullable = false)
    private String name ;
    private String description;

    @ElementCollection
    private Set<String> availableRoast;

    @ElementCollection
    private Set<Double> availableWeight;

    @ElementCollection
    private List<String> productImages;

    @Column(nullable = false)
    private Float price;

    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "categories_id" , nullable = false)
    @JsonBackReference
    private Categories category;


    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<OrderItem> orderItem;


    @OneToMany(mappedBy = "product" , cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Rate> rates;

    public Product
            (String name,
             String description,
             Float price,
             Integer stock,
             List<String> imagesPath)
    {
    }
    public static Product fromDTOtoEntity (ProductDTO productDTO){
        return Product.builder()
                .name(productDTO.name())
                .description(productDTO.description())
                .price(productDTO.price())
//                .productImages(productDTO.productImages())
                .stock(productDTO.stock())
                .build();
    }
}
