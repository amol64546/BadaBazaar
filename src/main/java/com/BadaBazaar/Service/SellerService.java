package com.BadaBazaar.Service;

import com.BadaBazaar.Model.Seller;
import com.BadaBazaar.RequestDto.SellerRequestDto;
import com.BadaBazaar.ResponseDto.SellerResponseDto;

import java.util.List;

public interface SellerService {

    public Seller addSeller(SellerRequestDto sellerRequestDto);
    public List<SellerResponseDto> getAllSellers();

    public SellerResponseDto getSellerByPan(String panNo);
}
