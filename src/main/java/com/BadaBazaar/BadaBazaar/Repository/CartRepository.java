package com.BadaBazaar.BadaBazaar.Repository;

import com.BadaBazaar.BadaBazaar.Model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart,String> {
}
