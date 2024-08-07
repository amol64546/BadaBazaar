package com.bada.bazaar.cache;

import com.bada.bazaar.entity.Seller;
import com.bada.bazaar.error.ApiException;
import com.bada.bazaar.error.ErrorConstants;
import com.bada.bazaar.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class SellerCache {

  private final SellerRepository sellerRepository;

  @CachePut(cacheNames = "seller", key = "#seller.id")
  public Seller saveSeller(Seller seller) {
    log.info("-----Persisting seller for id: {}-----", seller.getId());
    sellerRepository.save(seller);
    return seller;
  }

  @Cacheable(cacheNames = "seller", key = "#id")
  public Seller getSeller(Integer id) {
    log.info("-----Fetching seller from DB for id: {}-----", id);
    return sellerRepository.findById(id)
      .orElseThrow(()-> new ApiException(ErrorConstants.SELLER_NOT_FOUND));
  }

  @CacheEvict(value = "seller", key = "#id")
  public void deleteSeller(Integer id) {
    log.info("----- Evicting seller for id: {} -----", id);
    sellerRepository.deleteById(id);
  }

}

