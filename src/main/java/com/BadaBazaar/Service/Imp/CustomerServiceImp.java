package com.BadaBazaar.Service.Imp;

import com.BadaBazaar.Converter.CustomerConverter;
import com.BadaBazaar.Model.Cart;
import com.BadaBazaar.Model.Customer;
import com.BadaBazaar.Repository.CustomerRepository;
import com.BadaBazaar.RequestDto.CustomerRequestDto;
import com.BadaBazaar.ResponseDto.CustomerResponseDto;
import com.BadaBazaar.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public String addCustomer(CustomerRequestDto customerRequestDto) {

        Customer customer = CustomerConverter.CustomerRequestDtoToCustomer(customerRequestDto);

        Cart cart = new Cart();
        cart.setCartTotal(0);
        cart.setCustomerId(customer.get_id());

        customer.setCartId(cart.get_id());

        customerRepository.save(customer);

        return "Welcome to BadaBazaar.in";
    }

    public List<CustomerResponseDto> getAll() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();
        for(Customer c: customerList){
            customerResponseDtoList.add(CustomerConverter.CustomerToCustomerResponseDto(c));
        }
        return customerResponseDtoList;
    }

    @Override
    public CustomerResponseDto getCustomerById(String customerId) {
        Customer customer = customerRepository.findById(customerId).get();

        return CustomerConverter.CustomerToCustomerResponseDto(customer);
    }

    @Override
    public void deleteById(String customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public CustomerResponseDto getCustomerByEmail(String email) {
        Customer customer = customerRepository.findByEmail(email);
        return CustomerConverter.CustomerToCustomerResponseDto(customer);
    }

    @Override
    public CustomerResponseDto updateMobNo(String customerId, String mobNo) {
        Customer customer = customerRepository.findById(customerId).get();
        customer.setMobNo(mobNo);
        customerRepository.save(customer);
        return CustomerConverter.CustomerToCustomerResponseDto(customer);
    }

    @Override
    public CustomerResponseDto updateEmail(String customerId, String email) {
        Customer customer = customerRepository.findById(customerId).get();
        customer.setEmail(email);
        customerRepository.save(customer);
        return CustomerConverter.CustomerToCustomerResponseDto(customer);
    }
}
