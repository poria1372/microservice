package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.dto.ProductDTO;
import org.example.dto.ProductRequest;
import org.example.entity.Product;
import org.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

//    @PostMapping
//    public Product createProduct(@RequestBody Product product) {
//        return productService.create(product);
//    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductRequest productRequest){
        ProductDTO productDTO = productService.create(productRequest);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);

    }

}
