package com.BadaBazaar.ResponseDto;

import com.BadaBazaar.Enum.ProductCategory;
import com.BadaBazaar.Enum.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemResponseDto {
    private String productName;
    private int price;
    private ProductCategory productCategory;
    private ProductStatus productStatus;
}
