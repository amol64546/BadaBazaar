package com.BadaBazaar.Controller;

import com.BadaBazaar.RequestDto.CustomerRequestDto;
import com.BadaBazaar.ResponseDto.CustomerResponseDto;
import com.BadaBazaar.Service.Imp.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerServiceImp customerService;
    @PostMapping("/add")
    public String addCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        return customerService.addCustomer(customerRequestDto);
    }

    @GetMapping("/get/{customerId}")
    public CustomerResponseDto getCustomerById(@PathVariable String customerId) throws Exception {
        try{
            return customerService.getCustomerById(customerId);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @GetMapping("/get/all")
    public List<CustomerResponseDto> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/get/email")
    public CustomerResponseDto getCustomerByEmail(@RequestParam String email) throws Exception {
        try{
            return customerService.getCustomerByEmail(email);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @PutMapping("/update/mob")
    public CustomerResponseDto updateMobNo(@RequestParam String customerId,@RequestParam String mobNo) throws Exception{
        try{
            return customerService.updateMobNo(customerId,mobNo);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
    @PutMapping("/update/email")
    public CustomerResponseDto updateEmail(@RequestParam String customerId,@RequestParam String email) throws Exception{
        try{
            return customerService.updateEmail(customerId,email);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{customerId}")
    public String deleteById(@PathVariable String customerId) throws Exception{
        try{
            customerService.deleteById(customerId);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return "Customer with ID: "+customerId+" has been deleted.";
    }

}
