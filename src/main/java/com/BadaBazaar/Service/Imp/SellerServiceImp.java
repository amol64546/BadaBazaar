package com.BadaBazaar.Service.Imp;

import com.BadaBazaar.Converter.SellerConverter;
import com.BadaBazaar.Exception.SellerError;
import com.BadaBazaar.Model.Seller;
import com.BadaBazaar.Repository.SellerRepository;
import com.BadaBazaar.RequestDto.SellerRequestDto;
import com.BadaBazaar.ResponseDto.SellerResponseDto;
import com.BadaBazaar.Service.SellerService;
import com.gaian.services_error.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SellerServiceImp implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public Seller addSeller(SellerRequestDto sellerRequestDto) {
        Seller seller = SellerConverter.sellerRequestDtoToSeller(sellerRequestDto);
        return sellerRepository.save(seller);
    }

    @Override
    public List<SellerResponseDto> getAllSellers() {
        List<Seller> sellers = sellerRepository.findAll();

        List<SellerResponseDto> list = new ArrayList<>();

        for(Seller s: sellers){
            list.add(SellerConverter.sellerToSellerResponseDto(s));
        }
        return list;
    }

    public SellerResponseDto getSellerByPan(String panNo) {
        Seller seller = sellerRepository.findByPanNo(panNo);
        return SellerConverter.sellerToSellerResponseDto(seller);
    }

    public ResponseEntity<Void> deleteSeller(String sellerId) throws Exception
    {
        Optional<Seller> seller = sellerRepository.findById(sellerId);

        if (ObjectUtils.isEmpty(seller)) {
            throw new ApiException(SellerError.SELLER_NOT_FOUND);
        }
        sellerRepository.deleteById(sellerId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
