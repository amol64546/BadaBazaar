package com.BadaBazaar.Repository;

import com.BadaBazaar.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {
    Customer findByEmail(String email);
}
