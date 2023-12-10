package com.BadaBazaar.Service.Imp;

import com.BadaBazaar.Converter.ProductConverter;
import com.BadaBazaar.Enum.ProductCategory;
import com.BadaBazaar.Exception.SellerError;
import com.BadaBazaar.Repository.ProductRepository;
import com.BadaBazaar.RequestDto.ProductByCategoryRequestDto;
import com.BadaBazaar.Model.Product;
import com.BadaBazaar.Model.Seller;
import com.BadaBazaar.Repository.SellerRepository;
import com.BadaBazaar.ResponseDto.ProductResponseDto;
import com.BadaBazaar.Service.ProductService;
import com.gaian.services_error.exception.ApiException;
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
    public String addProduct(ProductByCategoryRequestDto productByCategoryRequestDto) {
        Seller seller;
        try{
            seller = sellerRepository.findById(productByCategoryRequestDto.getSellerId()).get();
        }catch (Exception e){
            throw new ApiException(SellerError.SELLER_NOT_FOUND);
        }

        Product product = ProductConverter.productRequestDtoToProduct(productByCategoryRequestDto);

        product.setSellerId(seller.get_id());
        seller.getProductList().add(product);

        sellerRepository.save(seller);
        productRepository.save(product);
        return "Product has been added";
    }

    @Override
    public List<ProductResponseDto> getProductByCategory(ProductCategory productCategory) {
        List<Product> productList = productRepository.findAllByProductCategory(productCategory);

        List<ProductResponseDto> productByCategoryResponseDtoList = new ArrayList<>();
        for(Product product: productList){
            productByCategoryResponseDtoList.add(ProductConverter.productToProductResponseDto(product));
        }
        return productByCategoryResponseDtoList;

    }
}
