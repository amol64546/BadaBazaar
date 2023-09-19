package com.BadaBazaar.Repository;

import com.BadaBazaar.Model.Ordered;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderRepository extends MongoRepository<Ordered,String> {

}
