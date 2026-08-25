package com.bada.bazaar.controller;

import com.bada.bazaar.dto.request.UserLoginRequest;
import com.bada.bazaar.dto.request.UserRegisterRequestDto;
import com.bada.bazaar.dto.response.UserResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name = "Authentication Controller")
@RequestMapping("/v1/auth")
public interface AuthController {

  @Operation(
    summary = "Register as seller or customer",
    description = "Registers a new user as either a seller or customer",
    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User registration details containing email, password, role, etc."),
    responses = {
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Returns the registered user's details")
    }
  )
  @PostMapping("/register")
  ResponseEntity<UserResponseDto> register(
    @Validated @Valid @RequestBody UserRegisterRequestDto userRegisterRequestDto
  );

  @Operation(
    summary = "Login and get token",
    description = "Authenticates a user and returns a JWT token",
    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "User credentials containing email and password"),
    responses = {
      @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Returns a JWT token and user basic details upon successful authentication")
    }
  )
  @PostMapping("/login")
  ResponseEntity<ModelMap> login(
    @Validated @Valid @RequestBody UserLoginRequest userLoginRequest);


}

