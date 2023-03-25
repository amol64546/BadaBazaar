package com.BadaBazaar.BadaBazaar.Service.Imp;

import com.BadaBazaar.BadaBazaar.Converter.ProductConverter;
import com.BadaBazaar.BadaBazaar.Enum.ProductCategory;
import com.BadaBazaar.BadaBazaar.Exception.SellerNotFoundException;
import com.BadaBazaar.BadaBazaar.Repository.ProductRepository;
import com.BadaBazaar.BadaBazaar.RequestDto.ProductRequestDto;
import com.BadaBazaar.BadaBazaar.Model.Product;
import com.BadaBazaar.BadaBazaar.Model.Seller;
import com.BadaBazaar.BadaBazaar.Repository.SellerRepository;
import com.BadaBazaar.BadaBazaar.ResponseDto.ProductResponseDto;
import com.BadaBazaar.BadaBazaar.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public String addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException {
        Seller seller;
        try{
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        }catch (Exception e){
            throw new SellerNotFoundException("Seller does not present");
        }

        Product product = ProductConverter.productRequestDtoToProduct(productRequestDto);

        product.setSeller(seller);
        seller.getProductList().add(product);

        sellerRepository.save(seller);
        return "Product has been added";
    }

    @Override
    public List<ProductResponseDto> getProductByCategory(ProductCategory productCategory) {
        List<Product> productList = productRepository.findAllByProductCategory(productCategory);

        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for(Product product: productList){
            productResponseDtoList.add(ProductConverter.productToProductResponseDto(product));
        }
        return productResponseDtoList;

    }
}
