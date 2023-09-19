package com.BadaBazaar.BadaBazaar.Service;

import com.BadaBazaar.BadaBazaar.Model.Seller;
import com.BadaBazaar.BadaBazaar.RequestDto.SellerRequestDto;
import com.BadaBazaar.BadaBazaar.ResponseDto.SellerResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SellerService {

    Mono<SellerResponseDto> addSeller(SellerRequestDto sellerRequestDto);
    Flux<SellerResponseDto> getAllSellers();

    Mono<SellerResponseDto> getSellerByPan(String panNo);
}
