package com.BadaBazaar.Repository;

import com.BadaBazaar.Model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CardRepository extends MongoRepository<Card,String> {


}
