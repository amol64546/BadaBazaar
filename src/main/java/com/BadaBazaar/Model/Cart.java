package com.BadaBazaar.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Cart {
    @Id
    private String _id;

    private int cartTotal;

    private String customerId;

    private List<Item> itemList = new ArrayList<>();
}
