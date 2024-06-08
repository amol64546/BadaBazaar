package com.BadaBazaar.BadaBazaar.service.Imp;

import com.BadaBazaar.BadaBazaar.converter.CardConverter;
import com.BadaBazaar.BadaBazaar.model.Card;
import com.BadaBazaar.BadaBazaar.model.Customer;
import com.BadaBazaar.BadaBazaar.repository.CardRepository;
import com.BadaBazaar.BadaBazaar.repository.CustomerRepository;
import com.BadaBazaar.BadaBazaar.requestDto.CardRequestDto;
import com.BadaBazaar.BadaBazaar.responseDto.CardDto;
import com.BadaBazaar.BadaBazaar.responseDto.CardResponseDto;
import com.BadaBazaar.BadaBazaar.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImp implements CardService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    CustomerRepository customerRepository;


    public CardResponseDto add(CardRequestDto cardRequestDto) throws Exception {
        Customer customer;
        try{
            customer = customerRepository.findById(cardRequestDto.getCustomerId()).get();
        }catch (Exception e){
            throw new Exception("customer does not present");
        }

        Card card = CardConverter.cardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);

        customer.getCardList().add(card);
        customerRepository.save(customer);

        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setCustomerName(customer.getName());

        List<CardDto> cardDtoList = new ArrayList<>();

        for(Card c: customer.getCardList()){
            CardDto cardDto = CardConverter.cardToCardDto(c);
            cardDtoList.add(cardDto);
        }
        cardResponseDto.setCardDtoList(cardDtoList);

        return cardResponseDto;
    }

    @Override
    public void remove(int customerId, int cardId) throws Exception{

        Customer customer = customerRepository.findById(customerId).get();
        Card card = cardRepository.findById(cardId).get();

        // card is not corresponding to customer
        if(!customer.getCardList().contains(card)){
            throw new Exception();
        }

        customer.getCardList().remove(card);
        cardRepository.delete(card);
    }

    @Override
    public CardResponseDto getAllCardsByCustomerId(int customerId) throws Exception{
        Customer customer;
        try{
            customer = customerRepository.findById(customerId).get();
        }catch (Exception e){
            throw new Exception("customer does not present");
        }

        CardResponseDto cardResponseDto = new CardResponseDto();
        cardResponseDto.setCustomerName(customer.getName());
        List<CardDto> cardDtoList = new ArrayList<>();

        for(Card c: customer.getCardList()){
            CardDto cardDto = CardConverter.cardToCardDto(c);
            cardDtoList.add(cardDto);
        }
        cardResponseDto.setCardDtoList(cardDtoList);

        return cardResponseDto;
    }


}