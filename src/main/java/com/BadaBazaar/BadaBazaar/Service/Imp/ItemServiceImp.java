package com.BadaBazaar.BadaBazaar.Service.Imp;

import com.BadaBazaar.BadaBazaar.Model.Item;
import com.BadaBazaar.BadaBazaar.Model.Product;
import com.BadaBazaar.BadaBazaar.Repository.CustomerRepository;
import com.BadaBazaar.BadaBazaar.Repository.ItemRepository;
import com.BadaBazaar.BadaBazaar.Repository.ProductRepository;
import com.BadaBazaar.BadaBazaar.ResponseDto.ItemResponseDto;
import com.BadaBazaar.BadaBazaar.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ItemRepository itemRepository;


    @Override
    public ItemResponseDto viewItem(String productId) throws Exception{

        Product product;

        try{
            product = productRepository.findById(productId).get();
        }catch (Exception e){
            throw new Exception("Product is not available");
        }

        Item item = Item.builder()
                .requiredQuantity(0)
                .productId(product.get_id())
                .build();

        itemRepository.save(item);

//        product.setItem(item);
//        productRepository.save(product);


        ItemResponseDto itemResponseDto = ItemResponseDto.builder()
                .price(product.getPrice())
                .productName(product.getName())
                .productStatus(product.getProductStatus())
                .productCategory(product.getProductCategory())
                .build();

        return itemResponseDto;
    }


}
