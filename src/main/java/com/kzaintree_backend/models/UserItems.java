package com.kzaintree_backend.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "UserItems")
public class UserItems {

    @Id
    private String id;
    @DBRef
    private String username;
    @DBRef
    private List<Items> items;

}

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Items")
class Items
{
    @Id
    private String id;
    private String sku;
    private String name;
    private String inStock;
    private String availableStock;
    private List<String> tags;
    private String category;
}
