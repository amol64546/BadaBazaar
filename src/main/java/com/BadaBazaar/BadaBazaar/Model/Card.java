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


//mongoDb
@Document(collection = "card")

//lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    private String _id;

    @Indexed(unique = true)
    @Field(name="cardNo")
    private String cardNo;

    private int cvv;
    private String expiry;

    private CardType cardType;

    private String customerId;
}
