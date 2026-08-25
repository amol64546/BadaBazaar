package com.bada.bazaar.controller;

import com.bada.bazaar.entity.User;
import com.bada.bazaar.enums.Role;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Admin Controller")
@RequestMapping("/v1/admin")
public interface AdminController {

  @Operation(
    summary = "Get users by role",
    description = "Retrieves a paginated list of users filtered by their role (CUSTOMER or SELLER)",
    responses = {
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "A paginated list of users matching the specified role")
    }
  )
  @GetMapping
  ResponseEntity<Page<User>> getUsersByRole(
    @RequestParam Role role,
    @Parameter(hidden = true) @PageableDefault(sort = "username",
      direction = Sort.Direction.DESC) Pageable pageable,
    HttpServletRequest request);


}
