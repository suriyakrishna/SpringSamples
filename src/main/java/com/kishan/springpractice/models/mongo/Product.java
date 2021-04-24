package com.kishan.springpractice.models.mongo;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Products")
public class Product {
    @Id
    private String id;
    private String name;
    private String category;
    private Map<String, Object> details;
}
