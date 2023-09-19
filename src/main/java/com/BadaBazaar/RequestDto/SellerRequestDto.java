package com.BadaBazaar.RequestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellerRequestDto {
    private String name;

    private String mobNo;

    private String email;

    private int age;

    private String panNo;
}
