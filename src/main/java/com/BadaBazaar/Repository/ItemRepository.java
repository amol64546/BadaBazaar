package com.BadaBazaar.Repository;

import com.BadaBazaar.Model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item,String> {
}
