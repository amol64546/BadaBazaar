package com.bada.bazaar.controller;

import com.bada.bazaar.dto.request.CardRequestDto;
import com.bada.bazaar.dto.response.CardResponseDto;
import com.bada.bazaar.entity.Card;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Tag(name = "Card Controller")
@RequestMapping("/v1/cards")
public interface CardController {

  @Operation(
    summary = "Add card",
    description = "Adds a new payment card to a customer's profile",
    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Details of the card to be added"),
    responses = {
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Returns the added card's details")
    }
  )
  @PostMapping
  ResponseEntity<CardResponseDto> addCardToCustomer(
    @RequestBody CardRequestDto cardRequestDto,
    HttpServletRequest request
  );

  @Operation(
    summary = "Remove card",
    description = "Removes a specific card from a customer's profile",
    responses = {
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Confirmation message of card removal")
    }
  )
  @DeleteMapping("{cardId}/customer/{customerId}")
  ResponseEntity<ModelMap> removeCardFromCustomer(
    @PathVariable Integer cardId,
    @PathVariable Integer customerId,
    HttpServletRequest request
  );

  @Operation(
    summary = "Get all cards",
    description = "Retrieves all payment cards associated with a specific customer",
    responses = {
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "A list of cards belonging to the customer")
    }
  )
  @GetMapping("{customerId}")
  ResponseEntity<List<Card>> getAllCardsOfCustomer(
    @PathVariable Integer customerId,
    HttpServletRequest request
  );


}
