package com.kishan.springpractice.models.mongo;


import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class ProductResponse {
    private String name;
    private String category;
    private Map<String, Object> details;
}

