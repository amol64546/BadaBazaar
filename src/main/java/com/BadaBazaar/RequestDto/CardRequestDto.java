package com.BadaBazaar.RequestDto;

import com.BadaBazaar.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardRequestDto {

    private String cardNo;
    private int cvv;
    private String expiry;

    private CardType cardType;
    private String customerId;
}
