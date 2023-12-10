package com.BadaBazaar.Service.Imp;

import com.BadaBazaar.Converter.ProductConverter;
import com.BadaBazaar.Enum.ProductStatus;
import com.BadaBazaar.Exception.CustomerError;
import com.BadaBazaar.Model.*;
import com.BadaBazaar.Repository.CustomerRepository;
import com.BadaBazaar.Repository.OrderRepository;
import com.BadaBazaar.Repository.ProductRepository;
import com.BadaBazaar.RequestDto.OrderRequestDto;
import com.BadaBazaar.ResponseDto.ItemResponseDto;
import com.BadaBazaar.ResponseDto.OrderResponseDto;
import com.BadaBazaar.Service.CartService;
import com.gaian.services_error.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImp implements CartService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Override
    public String addToCart(OrderRequestDto orderRequestDto) throws Exception{

        // check for customer
        Customer customer;
        try{
            customer = customerRepository.findById(orderRequestDto.getCustomerId()).get();
        }catch (Exception e){
            throw new Exception("Customer is not available");
        }

        // check for product
        Product product;
        try{
            product = productRepository.findById(orderRequestDto.getProductId()).get();
        }catch (Exception e){
            throw new Exception("Product is not available");
        }

        // check for product quantity
        if(product.getQuantity() == 0 ){
            throw new Exception("Product is out of stock");
        }
        if(product.getQuantity() < orderRequestDto.getRequiredQuantity()){
            throw new Exception("Product quantity is less");
        }

        Cart cart = mongoTemplate.findById(customer.getCartId(), Cart.class);
        cart.setCartTotal(product.getPrice() * orderRequestDto.getRequiredQuantity());
        cart.setCustomerId(customer.get_id());

        // Item
        Item item = new Item();
        item.setRequiredQuantity(orderRequestDto.getRequiredQuantity());
        item.setProductId(product.get_id());
        item.setCartId(cart.get_id());

        cart.getItemList().add(item);

        customerRepository.save(customer);

        return "Item has been added to your Cart!!";
    }

    @Override
    public List<OrderResponseDto> checkout(String customerId) throws Exception{
        Customer customer;
        try{
            customer = customerRepository.findById(customerId).get();
        }
        catch(Exception e){
            throw new ApiException(CustomerError.CUSTOMER_NOT_FOUND);
        }

        List<OrderResponseDto> orderResponseDtoList = new ArrayList<>();

        Cart cart = mongoTemplate.findById(customer.getCartId(), Cart.class);
        int totalCost = cart.getCartTotal();

        for(Item item: cart.getItemList()){

            Product product = mongoTemplate.findById(item.getProductId(),Product.class);

            // check for product quantity
            if(product.getQuantity() == 0 ){
                throw new Exception("Product is out of stock");
            }
            if(product.getQuantity() < item.getRequiredQuantity()){
                throw new Exception("Product quantity is less");
            }

            // order
            Ordered ordered = new Ordered();
            ordered.setTotalCost(product.getPrice() * item.getRequiredQuantity());
            ordered.setDeliveryCharge(40);
            ordered.getItemList().add(item);
            ordered.setCustomerId(customer.get_id());

            // Card
            Card card = customer.getCardList().get(0);
            String cardNo = "";
            int len = card.getCardNo().length();
            for(int i=0;i<len-4;i++)
                cardNo += 'X';
            cardNo += card.getCardNo().substring(len-4);

            ordered.setCardUsedForPayment(cardNo);

            item.setOrderedId(ordered.get_id());
            customer.getOrderList().add(ordered);

            // product quantity
            int leftQuantity = product.getQuantity()- item.getRequiredQuantity();
            if(leftQuantity<=0){
                product.setProductStatus(ProductStatus.OUT_OF_STOCK);
            }
            product.setQuantity(leftQuantity);

            orderRepository.save(ordered);

            OrderResponseDto orderResponseDto = OrderResponseDto.builder()
                    .productName(product.getName())
                    .itemPrice(product.getPrice())
                    .totalCost(ordered.getTotalCost())
                    .deliveryCharge(40)
                    .cardUsedForPayment(cardNo)
                    .quantityOrdered(item.getRequiredQuantity())
                    .orderDate(ordered.getOrderDate())
                    .build();

            orderResponseDtoList.add(orderResponseDto);

        }


        cart.setItemList(new ArrayList<>());
        cart.setCartTotal(0);

        customerRepository.save(customer);

        return  orderResponseDtoList;
    }

    @Override
    public List<ItemResponseDto> viewItems(String customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        List<ItemResponseDto> itemResponseDtos = new ArrayList<>();

        Cart cart = mongoTemplate.findById(customer.getCartId(), Cart.class);
        for(Item item:  cart.getItemList()){
            Product product = mongoTemplate.findById(item.getProductId(),Product.class);
            itemResponseDtos.add(ProductConverter.productToItemResponseDto(product));
        }
        return itemResponseDtos;
    }


}
