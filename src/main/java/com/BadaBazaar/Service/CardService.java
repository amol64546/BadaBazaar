package com.BadaBazaar.Service;

import com.BadaBazaar.RequestDto.CardRequestDto;
import com.BadaBazaar.ResponseDto.CardResponseDto;

public interface CardService {
    public CardResponseDto add(CardRequestDto cardRequestDto) throws Exception;

    void remove(String customerId, String cardId)throws Exception;

    CardResponseDto getAllCardsByCustomerId(String customerId) throws Exception;


}
