package com.BadaBazaar.BadaBazaar.Controller;

import com.BadaBazaar.BadaBazaar.RequestDto.SellerRequestDto;
import com.BadaBazaar.BadaBazaar.ResponseDto.SellerResponseDto;
import com.BadaBazaar.BadaBazaar.Service.Imp.SellerServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping("/seller")
@Slf4j
public class SellerController {

    @Autowired
    SellerServiceImp sellerService;

    @PostMapping("/add")
    public ResponseEntity addSeller(
            @RequestBody SellerRequestDto sellerRequestDto){

        log.info("Seller adding..........");

        return new ResponseEntity(sellerService.addSeller(sellerRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public List<SellerResponseDto> getAllSellers(){
        return sellerService.getAllSellers();
    }

    @GetMapping("/get/pan")
    public SellerResponseDto getSellerByPan(@RequestParam String panNo){
        return sellerService.getSellerByPan(panNo);
    }

}
