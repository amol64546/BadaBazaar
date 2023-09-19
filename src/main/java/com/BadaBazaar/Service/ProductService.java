package com.BadaBazaar.Service;

import com.BadaBazaar.Enum.ProductCategory;
import com.BadaBazaar.Exception.SellerNotFoundException;
import com.BadaBazaar.RequestDto.ProductByCategoryRequestDto;
import com.BadaBazaar.ResponseDto.ProductResponseDto;

import java.util.List;

public interface ProductService {

    public String addProduct(ProductByCategoryRequestDto productByCategoryRequestDto) throws SellerNotFoundException;

    public List<ProductResponseDto> getProductByCategory(ProductCategory productCategory);
}
