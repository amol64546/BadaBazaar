package com.BadaBazaar.Service;

import com.BadaBazaar.RequestDto.OrderRequestDto;
import com.BadaBazaar.ResponseDto.ItemResponseDto;
import com.BadaBazaar.ResponseDto.OrderResponseDto;

import java.util.List;

public interface CartService {
    String addToCart(OrderRequestDto orderRequestDto)throws Exception;

    List<OrderResponseDto> checkout(String customerId)throws Exception;

    List<ItemResponseDto> viewItems(String customerId);
}
