package com.BadaBazaar.Service;

import com.BadaBazaar.RequestDto.OrderRequestDto;
import com.BadaBazaar.ResponseDto.OrderResponseDto;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderService {

    public OrderResponseDto placeOrder(@RequestBody OrderRequestDto orderRequestDto) throws Exception;


}
