package com.bada.bazaar.repository;

import com.bada.bazaar.model.Ordered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrderedRepository extends JpaRepository<Ordered,Integer> {

}
