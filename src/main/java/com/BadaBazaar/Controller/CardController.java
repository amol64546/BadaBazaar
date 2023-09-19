package com.BadaBazaar.Controller;

import com.BadaBazaar.RequestDto.CardRequestDto;
import com.BadaBazaar.ResponseDto.CardResponseDto;
import com.BadaBazaar.Service.Imp.CardServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardServiceImp cardService;

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody CardRequestDto cardRequestDto) {
        CardResponseDto cardResponseDto;
        try{
            cardResponseDto = cardService.add(cardRequestDto);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(cardResponseDto,HttpStatus.CREATED);

    }

    @DeleteMapping("/delete")
    public ResponseEntity remove(@RequestParam String customerId , @RequestParam String cardId){

        try{
            cardService.remove(customerId, cardId);
        }catch (Exception e){
            return new ResponseEntity("Invalid card", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity("Card has been deleted", HttpStatus.ACCEPTED);
    }

    @GetMapping("/view/all")
    public ResponseEntity getAllCardsByCustomerId(@RequestParam String customerId) {
        CardResponseDto cardResponseDto;
        try{
            cardResponseDto = cardService.getAllCardsByCustomerId(customerId);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(cardResponseDto,HttpStatus.OK);
    }



}
