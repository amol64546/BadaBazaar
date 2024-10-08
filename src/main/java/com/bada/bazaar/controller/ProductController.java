package com.bada.bazaar.controller;

import com.bada.bazaar.dto.request.ProductPostRequestDto;
import com.bada.bazaar.dto.request.ProductPutRequestDto;
import com.bada.bazaar.dto.response.ProductResponseDto;
import com.bada.bazaar.entity.Product;
import com.bada.bazaar.enums.Category;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Product Controller")
@RequestMapping("/v1/products")
public interface ProductController {

  //       ROLE - SELLER
  @Operation(summary = "Add product")
  @PostMapping
  ResponseEntity<ProductResponseDto> addProductBySellerId(
    @Validated @Valid @RequestBody ProductPostRequestDto productPostRequestDto,
    HttpServletRequest request);

  @Operation(summary = "Update product")
  @PutMapping
  ResponseEntity<ProductResponseDto> updateProduct(
    @Validated @Valid @RequestBody ProductPutRequestDto productPutRequestDto,
    HttpServletRequest request);

  @Operation(summary = "Remove product")
  @DeleteMapping("/{productId}")
  ResponseEntity<ModelMap> deleteProduct(@PathVariable Integer productId,
                                         HttpServletRequest request);

  @Operation(summary = "Get products by sellerId")
  @GetMapping("/{sellerId}")
  ResponseEntity<Page<Product>> getProductsBySellerId(
    @PathVariable Integer sellerId,
    @Parameter(hidden = true) @PageableDefault(sort = "dateAdded",
      direction = Sort.Direction.DESC) Pageable pageable,
    HttpServletRequest request);


  @Operation(summary = "Get products by category")
  @GetMapping("category/{category}")
  ResponseEntity<Page<Product>> getProductByCategory(
    @PathVariable Category category,
    @Parameter(hidden = true) @PageableDefault(sort = "dateAdded",
      direction = Sort.Direction.DESC) Pageable pageable,
    HttpServletRequest request);

}
