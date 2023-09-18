package com.BadaBazaar.BadaBazaar.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Item {
    @Id
    private String _id;

    private int requiredQuantity;

//    @ManyToOne
//    @JoinColumn
    private String cartId;

//    @OneToOne
//    @JoinColumn
    private String productId;

//    @ManyToOne
//    @JoinColumn
    private String orderedId;

}
