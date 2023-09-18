package com.BadaBazaar.BadaBazaar.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Customer {

    @Id
    private String _id;

    private String name;

    @Indexed(unique = true)
    private String mobNo;

    @Indexed(unique = true)
    private String email;

    private int age;

    private List<Card> cardList = new ArrayList<>();

    private String cartId;

    private List<Ordered> orderList = new ArrayList<>();

}
