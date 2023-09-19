package com.BadaBazaar.BadaBazaar.Service.Imp;

import com.BadaBazaar.BadaBazaar.Converter.SellerConverter;
import com.BadaBazaar.BadaBazaar.RequestDto.SellerRequestDto;
import com.BadaBazaar.BadaBazaar.Model.Seller;
import com.BadaBazaar.BadaBazaar.Repository.SellerRepository;
import com.BadaBazaar.BadaBazaar.ResponseDto.SellerResponseDto;
import com.BadaBazaar.BadaBazaar.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;


@Service
public class SellerServiceImp implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public Mono<String> addSeller(SellerRequestDto sellerRequestDto) {
        Seller seller = SellerConverter.sellerRequestDtoToSeller(sellerRequestDto);
        return sellerRepository.save(seller)
                .map(savedSeller -> "Seller ID: " + savedSeller.get_id());
    }

    @Override
    public Flux<SellerResponseDto> getAllSellers() {
        return sellerRepository.findAll()
                .map(SellerConverter::sellerToSellerResponseDto);
    }

    public Mono<SellerResponseDto> getSellerByPan(String panNo) {
        return sellerRepository.findByPanNo(panNo)
                .map(SellerConverter::sellerToSellerResponseDto);
    }
}
