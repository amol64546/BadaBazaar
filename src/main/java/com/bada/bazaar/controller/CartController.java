package com.bada.bazaar.controller;

import com.bada.bazaar.dto.request.OrderRequestDto;
import com.bada.bazaar.entity.Item;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Cart Controller")
@RequestMapping("/v1/carts")
public interface CartController {

  @Operation(
    summary = "Add product to cart",
    description = "Adds a specific quantity of a product to the user's cart",
    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Details of the product and quantity to add to the cart"),
    responses = {
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Confirmation message of the addition")
    }
  )
  @PostMapping
  ResponseEntity<ModelMap> addToCart(@RequestBody OrderRequestDto orderRequestDto,
                                     HttpServletRequest request);

  @Operation(
    summary = "Checkout cart",
    description = "Initiates the checkout process for the items currently in the cart",
    responses = {
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Confirmation message or order summary upon successful checkout")
    }
  )
  @PostMapping("{customerId}")
  ResponseEntity<ModelMap> checkout(@PathVariable Integer customerId,
                                    Integer cardId,
                                    HttpServletRequest request);

  @Operation(
    summary = "Get all products in cart",
    description = "Retrieves a paginated list of all items present in the user's cart",
    responses = {
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "A paginated list of items in the cart")
    }
  )
  @GetMapping("{customerId}")
  ResponseEntity<Page<Item>> viewItems(@PathVariable Integer customerId,
                                       @Parameter(hidden = true) @PageableDefault(sort = "dateAdded",
                                         direction = Sort.Direction.DESC) Pageable pageable,
                                       HttpServletRequest request);

}
