package com.bada.bazaar.service;

import com.bada.bazaar.dto.response.CustomerResponseDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface CustomerService {


  List<CustomerResponseDto> retrieveAllCustomers(Pageable pageable);
}
