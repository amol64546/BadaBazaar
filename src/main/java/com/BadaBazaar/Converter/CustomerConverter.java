package com.BadaBazaar.Converter;

import com.BadaBazaar.Model.Customer;
import com.BadaBazaar.RequestDto.CustomerRequestDto;
import com.BadaBazaar.ResponseDto.CustomerResponseDto;
import lombok.Builder;
import lombok.experimental.UtilityClass;

@Builder
@UtilityClass
public class CustomerConverter {

    public static Customer CustomerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){
        return Customer.builder()
                .name(customerRequestDto.getName())
                .age(customerRequestDto.getAge())
                .mobNo(customerRequestDto.getMobNo())
                .email(customerRequestDto.getEmail())
                .build();
    }

    public static CustomerResponseDto CustomerToCustomerResponseDto(Customer customer){
        return CustomerResponseDto.builder()
                .name(customer.getName())
                .age(customer.getAge())
                .mobNo(customer.getMobNo())
                .email(customer.getEmail())
                .build();
    }
}
