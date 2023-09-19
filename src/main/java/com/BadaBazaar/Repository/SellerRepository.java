package com.BadaBazaar.Repository;

import com.BadaBazaar.Model.Seller;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends MongoRepository<Seller,String> {

    Seller findByPanNo(String panNo);
}
