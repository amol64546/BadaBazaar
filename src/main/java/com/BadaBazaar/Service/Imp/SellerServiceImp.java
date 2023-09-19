package com.BadaBazaar.Service.Imp;

import com.BadaBazaar.Converter.SellerConverter;
import com.BadaBazaar.RequestDto.SellerRequestDto;
import com.BadaBazaar.Model.Seller;
import com.BadaBazaar.Repository.SellerRepository;
import com.BadaBazaar.ResponseDto.SellerResponseDto;
import com.BadaBazaar.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SellerServiceImp implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public String addSeller(SellerRequestDto sellerRequestDto) {
        Seller seller = SellerConverter.sellerRequestDtoToSeller(sellerRequestDto);

        sellerRepository.save(seller);
        return "Seller ID: " + seller.get_id();
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
}
