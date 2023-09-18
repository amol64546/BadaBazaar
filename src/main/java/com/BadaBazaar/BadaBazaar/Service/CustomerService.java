package com.BadaBazaar.BadaBazaar.Service;

import com.BadaBazaar.BadaBazaar.RequestDto.CustomerRequestDto;
import com.BadaBazaar.BadaBazaar.ResponseDto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {

     String addCustomer(CustomerRequestDto customerRequestDto);

     List<CustomerResponseDto> getAll();

    CustomerResponseDto getCustomerById(String customerId);

    void deleteById(String customerId);

    CustomerResponseDto getCustomerByEmail(String email);

    CustomerResponseDto updateMobNo(String customerId,String mobNo);

    CustomerResponseDto updateEmail(String customerId, String email);
}
