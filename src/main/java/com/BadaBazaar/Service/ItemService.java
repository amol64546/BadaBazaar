package com.BadaBazaar.Service;

import com.BadaBazaar.ResponseDto.ItemResponseDto;

public interface ItemService {

    public ItemResponseDto viewItem(String productId) throws Exception;


}
