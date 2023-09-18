package com.BadaBazaar.BadaBazaar.Model;

import com.BadaBazaar.BadaBazaar.Enum.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//mySql
//@Entity
//@Table(name = "card")

//mongoDb
@Document(collection = "card")

//lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    private String _id;

//    @Column(unique = true)
    @Indexed(unique = true)
    @Field(name="cardNo")
    private String cardNo;

    private int cvv;
    private String expiry;

//    @Enumerated(EnumType.STRING)
    private CardType cardType;

//    @ManyToOne
//    @JoinColumn
//    private Customer customer;
    private String customerId;
}
