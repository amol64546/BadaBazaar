package com.BadaBazaar.BadaBazaar.Converter;

import com.BadaBazaar.BadaBazaar.Model.Seller;
import com.BadaBazaar.BadaBazaar.RequestDto.SellerRequestDto;
import com.BadaBazaar.BadaBazaar.ResponseDto.SellerResponseDto;
import lombok.Builder;
import lombok.experimental.UtilityClass;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@UtilityClass
@Builder
public class SellerConverter {

    public static Seller sellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){
        return Seller.builder()
                .name(sellerRequestDto.getName())
                .age(sellerRequestDto.getAge())
                .email(sellerRequestDto.getEmail())
                .panNo(sellerRequestDto.getPanNo())
                .mobNo(sellerRequestDto.getMobNo())
                .build();
    }

    public static Flux<Seller> sellerRequestDtoToSeller(Flux<SellerRequestDto> sellerRequestDtoFlux){
        return sellerRequestDtoFlux.map(sellerRequestDto->
                Seller.builder()
                        .name(sellerRequestDto.getName())
                        .age(sellerRequestDto.getAge())
                        .email(sellerRequestDto.getEmail())
                        .panNo(sellerRequestDto.getPanNo())
                        .mobNo(sellerRequestDto.getMobNo())
                        .build()
        );
    }

    public static Mono<Seller> sellerRequestDtoToSeller(Mono<SellerRequestDto> sellerRequestDtoMono){
        return sellerRequestDtoMono.map(sellerRequestDto->
                Seller.builder()
                        .name(sellerRequestDto.getName())
                        .age(sellerRequestDto.getAge())
                        .email(sellerRequestDto.getEmail())
                        .panNo(sellerRequestDto.getPanNo())
                        .mobNo(sellerRequestDto.getMobNo())
                        .build()
        );
    }

    public static SellerResponseDto sellerToSellerResponseDto(Seller seller){
        return SellerResponseDto.builder()
                .name(seller.getName())
                .age(seller.getAge())
                .email(seller.getEmail())
                .panNo(seller.getPanNo())
                .mobNo(seller.getMobNo())
                .build();
    }

    public static Flux<SellerResponseDto> sellerToSellerResponseDto(Flux<Seller> sellerFlux){
        return sellerFlux.map( seller->
                SellerResponseDto.builder()
                        .name(seller.getName())
                        .age(seller.getAge())
                        .email(seller.getEmail())
                        .panNo(seller.getPanNo())
                        .mobNo(seller.getMobNo())
                        .build()
        );
    }
    public static Mono<SellerResponseDto> sellerToSellerResponseDto(Mono<Seller> sellerMono){
        return sellerMono.map( seller->
                SellerResponseDto.builder()
                        .name(seller.getName())
                        .age(seller.getAge())
                        .email(seller.getEmail())
                        .panNo(seller.getPanNo())
                        .mobNo(seller.getMobNo())
                        .build()
        );
    }
}
