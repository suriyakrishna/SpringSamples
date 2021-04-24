package com.kishan.springpractice.services.mongo;

import com.kishan.springpractice.models.mongo.Product;
import com.kishan.springpractice.models.mongo.ProductResponse;
import com.kishan.springpractice.repos.SpringMongoOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ProductService {

    private SpringMongoOperations springMongoOperations;

    @Autowired
    public ProductService(SpringMongoOperations springMongoOperations) {
        this.springMongoOperations = springMongoOperations;
    }

    public Collection<ProductResponse> getProductByName(String name) {
        Collection<Product> products = springMongoOperations.findProductByName(name);
        Collection<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : products) {
            productResponses.add(mapProductResponse(product));
        }
        return productResponses;
    }

    private ProductResponse mapProductResponse(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .category(product.getCategory())
                .details(product.getDetails())
                .build();
    }
}
