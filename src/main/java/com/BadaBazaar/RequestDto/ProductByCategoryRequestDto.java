package com.BadaBazaar.RequestDto;

import com.BadaBazaar.Enum.ProductCategory;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductByCategoryRequestDto {

    private String name;
    private int price;
    private int quantity;

    private ProductCategory productCategory;

    private String sellerId;
}
