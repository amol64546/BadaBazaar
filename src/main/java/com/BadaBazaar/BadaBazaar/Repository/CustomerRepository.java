package com.BadaBazaar.BadaBazaar.Repository;

import com.BadaBazaar.BadaBazaar.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {
    Customer findByEmail(String email);
}
