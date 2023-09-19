package com.BadaBazaar.Controller;

import com.BadaBazaar.RequestDto.OrderRequestDto;
import com.BadaBazaar.ResponseDto.OrderResponseDto;
import com.BadaBazaar.Service.Imp.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderServiceImp orderService;

    @PostMapping("/place")
    public ResponseEntity placeOrder(@RequestBody OrderRequestDto orderRequestDto){
        OrderResponseDto orderResponseDto;
        try{
            orderResponseDto = orderService.placeOrder(orderRequestDto);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(orderResponseDto,HttpStatus.ACCEPTED);
    }


}
