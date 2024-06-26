package com.bada.bazaar.requestDto;

import com.bada.bazaar.enums.Category;
import com.bada.bazaar.enums.SubCategory;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductRequestDto {

    @NotBlank(message = "Product name is required")
    private String name;

    private Integer quantity;

    private Category category;
    private Enum<?> subCategory;

    @NotBlank(message = "Seller id is required")
    private Integer sellerId;

    private String description;
    private Double price;
    private Integer stock;
    private byte[] image;

    private Map<String,String> characteristics;


    private List<String> tags = new LinkedList<>();

}
