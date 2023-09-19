package com.BadaBazaar.Controller;

import com.BadaBazaar.ResponseDto.ItemResponseDto;
import com.BadaBazaar.Service.Imp.ItemServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemServiceImp itemService;

    @GetMapping("/view/{productId}")
    public ItemResponseDto viewItem(@PathVariable("productId") String productId ) throws Exception {
        return itemService.viewItem(productId);
    }





}
