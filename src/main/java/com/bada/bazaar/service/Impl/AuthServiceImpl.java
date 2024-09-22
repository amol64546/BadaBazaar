package com.bada.bazaar.service.Impl;

import com.bada.bazaar.cache.RedisService;
import com.bada.bazaar.converter.UserConverter;
import com.bada.bazaar.dto.request.UserLoginRequest;
import com.bada.bazaar.dto.request.UserRegisterRequestDto;
import com.bada.bazaar.dto.response.UserResponseDto;
import com.bada.bazaar.entity.Cart;
import com.bada.bazaar.entity.Customer;
import com.bada.bazaar.entity.Seller;
import com.bada.bazaar.entity.User;
import com.bada.bazaar.enums.Role;
import com.bada.bazaar.error.ApiException;
import com.bada.bazaar.error.ErrorConstants;
import com.bada.bazaar.repository.CartRepository;
import com.bada.bazaar.repository.CustomerRepository;
import com.bada.bazaar.repository.SellerRepository;
import com.bada.bazaar.repository.UserRepository;
import com.bada.bazaar.service.AuthService;
import com.bada.bazaar.util.JwtHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final AuthenticationManager authenticationManager;
  private final UserRepository userRepository;
  private final CustomerRepository customerRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserConverter userConverter;
  private final RedisService redisService;
  private final SellerRepository sellerRepository;
  private final CartRepository cartRepository;

  @Override
  public UserResponseDto register(UserRegisterRequestDto userRegisterRequestDto) {
    Optional<User> user = userRepository.findByUsername(userRegisterRequestDto.getUsername());
    if (user.isPresent()) {
      throw new ApiException(ErrorConstants.USER_ALREADY_EXISTS);
    }

    User userEntity = userConverter.userRegisterRequestDtoToUser(userRegisterRequestDto);

    UserResponseDto userResponseDto;
    if (userRegisterRequestDto.getRole().name().equals(Role.SELLER.name())) {
      userResponseDto = createSellerUser(userRegisterRequestDto);
    } else {
      userResponseDto = createCustomerUser(userRegisterRequestDto);
    }
    userEntity.setId(userResponseDto.getId());
    userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
    userRepository.save(userEntity);
    return userResponseDto;
  }


  public UserResponseDto createSellerUser(UserRegisterRequestDto userRegisterRequestDto) {
    Seller seller = userConverter.userRegisterRequestDtoToSeller(userRegisterRequestDto);
    seller.setDateJoined(new Date());
    seller.setLastModifiedDate(new Date());

    seller = sellerRepository.save(seller);
    redisService.save(String.valueOf(seller.getId()), seller);
    return userConverter.sellerToUserResponseDto(seller);
  }

  public UserResponseDto createCustomerUser(UserRegisterRequestDto userRegisterRequestDto) {
    Customer customer = userConverter.userRegisterRequestDtoToCustomer(userRegisterRequestDto);
    customer.setDateJoined(new Date());
    customer.setLastModifiedDate(new Date());

    Cart cart = new Cart();
    cart = cartRepository.save(cart);
    customer.setCartId(cart.getId());
    customer = customerRepository.save(customer);
    redisService.save(String.valueOf(customer.getId()), customer);
    return userConverter.customerToUserResponseDto(customer);
  }


  @Override
  public String login(UserLoginRequest userLoginRequest) {
    authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        userLoginRequest.getUsername(),
        userLoginRequest.getPassword()));
    Optional<User> user = userRepository.findByUsername(userLoginRequest.getUsername());
    if (user.isEmpty()) {
      throw new ApiException(ErrorConstants.USER_NOT_FOUND);
    }
    return JwtHelper.generateToken(user.get());
  }

}

