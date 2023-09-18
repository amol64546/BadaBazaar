package com.BadaBazaar.BadaBazaar.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Seller {
    @Id
    private String _id;

    private String name;

    @Indexed(unique = true)
    private String mobNo;

    @Indexed(unique = true)
    private String email;

    private int age;

    @Indexed(unique = true)
    private String panNo;

//    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();


}
