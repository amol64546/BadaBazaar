package com.bada.bazaar.controller;

import com.bada.bazaar.dto.response.ItemResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Item Controller")
@RequestMapping("/v1/items")
public interface ItemController {


  @Operation(
    summary = "View product",
    description = "Retrieves detailed information about a specific product item",
    responses = {
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Detailed product item information")
    }
  )
  @GetMapping("/{productId}")
  ResponseEntity<ItemResponseDto> viewItem(
    @PathVariable int productId,
    HttpServletRequest request);

}
