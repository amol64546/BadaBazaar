package com.BadaBazaar.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequestDto {
    private String productId;
    private String customerId;
    private int requiredQuantity;
}
