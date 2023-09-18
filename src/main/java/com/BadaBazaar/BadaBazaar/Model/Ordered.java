package com.BadaBazaar.BadaBazaar.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Ordered {
    @Id
    private String _id;

    @CreatedDate
    private Date orderDate;

    private int totalCost;

    private int deliveryCharge;

    private String cardUsedForPayment;

//    @ManyToOne
//    @JoinColumn
    private String customerId;

//    @OneToMany(mappedBy = "ordered",cascade = CascadeType.ALL)
    private List<Item> itemList = new ArrayList<>();

}
