package com.BadaBazaar.Controller;

import com.BadaBazaar.RequestDto.OrderRequestDto;
import com.BadaBazaar.ResponseDto.ItemResponseDto;
import com.BadaBazaar.ResponseDto.OrderResponseDto;
import com.BadaBazaar.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/add")
    public String addToCart(@RequestBody OrderRequestDto orderRequestDto)throws Exception{
        String response = "";
        try{
            response = cartService.addToCart(orderRequestDto);
        }catch (Exception e){
            return e.getMessage();
        }
        return response;
    }

    @PostMapping("/checkout/{customerId}")
    public ResponseEntity checkout(@PathVariable String customerId)throws Exception{
        List<OrderResponseDto> orderResponseDtoList;
        try{
            orderResponseDtoList = cartService.checkout(customerId);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(orderResponseDtoList,HttpStatus.ACCEPTED);

    }

    @GetMapping("/view/{customerId}")
    public List<ItemResponseDto> viewItems(@PathVariable String customerId)throws Exception{
        return cartService.viewItems(customerId);
    }




}
