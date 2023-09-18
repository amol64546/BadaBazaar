package com.BadaBazaar.BadaBazaar.Repository;

import com.BadaBazaar.BadaBazaar.Model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
//public interface CardRepository extends JpaRepository<Card,Integer> {
public interface CardRepository extends MongoRepository<Card,String> {


}
