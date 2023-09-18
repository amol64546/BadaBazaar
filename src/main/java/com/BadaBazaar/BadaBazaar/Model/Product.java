package com.BadaBazaar.BadaBazaar.Model;

import com.BadaBazaar.BadaBazaar.Enum.ProductCategory;
import com.BadaBazaar.BadaBazaar.Enum.ProductStatus;
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
public class Product {
    @Id
    private String _id;
    private String name;
    private int price;
    private int quantity;

//    @Enumerated(EnumType.STRING)
    private ProductCategory productCategory;

//    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;


//    @ManyToOne
//    @JoinColumn
//    @DBRef
    private String sellerId;

    //    @OneToOne(mappedBy = "product",cascade = CascadeType.ALL)
    private String itemId;

}
