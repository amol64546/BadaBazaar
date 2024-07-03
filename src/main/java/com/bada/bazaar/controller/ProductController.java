package com.bada.bazaar.controller;

import com.bada.bazaar.requestDto.ProductPostRequestDto;
import com.bada.bazaar.requestDto.ProductPutRequestDto;
import com.bada.bazaar.responseDto.ProductResponseDto;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1/products")
public interface ProductController {

  //       ROLE - SELLER
  @PostMapping
  ResponseEntity<ProductResponseDto> addProductBySellerId(
    @Validated @Valid @RequestBody ProductPostRequestDto productPostRequestDto,
    BindingResult bindingResult, HttpServletRequest request);

  @PutMapping("{productId}")
  ResponseEntity<ProductResponseDto> updateProduct(@PathVariable Integer productId,
    @Validated @Valid @RequestBody ProductPutRequestDto productPutRequestDto,
    BindingResult bindingResult,
    HttpServletRequest request);

  @DeleteMapping("{productId}")
  ResponseEntity<ModelMap> deleteProduct(@PathVariable Integer productId,
    HttpServletRequest request);


  // ROLE - SELLER/CUSTOMER
  @GetMapping("{productId}")
  ResponseEntity<ProductResponseDto> getProductById(@PathVariable Integer productId,
    HttpServletRequest request);

  @GetMapping("seller")
  ResponseEntity<List<ProductResponseDto>> getProductsBySellerId(
    @Parameter(hidden = true) @PageableDefault(sort = "dateAdded",
      direction = Sort.Direction.DESC) Pageable pageable,
    HttpServletRequest request);

  @GetMapping
  ResponseEntity<List<ProductResponseDto>> getAllProducts(
    @Parameter(hidden = true) @PageableDefault(sort = "dateAdded",
      direction = Sort.Direction.DESC) Pageable pageable,
    HttpServletRequest request);
}
