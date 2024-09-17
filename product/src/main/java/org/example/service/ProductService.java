package org.example.service;

import org.example.dto.ProductDTO;
import org.example.dto.ProductRequest;
import org.example.entity.Discount;
import org.example.entity.Product;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.math.BigDecimal;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestClient restClient;

//    @Autowired
//    private RestTemplate restTemplate;

//    public Product create(Product product) {
//        Discount discount = restTemplate.getForObject("http://localhost:9090/api/v1/coupons/{couponName}", Discount.class, product.getCouponCode()); //خروجی یک دیسکانت است
//        BigDecimal subTrack = new BigDecimal(100).subtract(discount.getCoupon());
//        product.setPrice(subTrack.multiply(product.getPrice()).divide(new BigDecimal(100)));
//        Product save = productRepository.save(product);
//        return save;
//    }

//    public Product create(Product product) {
//        Discount discount = restClient.get().uri("http://localhost:9090/api/v1/coupons/{couponName}", product.getCouponCode()).retrieve().body(Discount.class); //خروجی یک دیسکانت است
//        BigDecimal subTrack = new BigDecimal(100).subtract(discount.getCoupon());
//        product.setPrice(subTrack.multiply(product.getPrice()).divide(new BigDecimal(100)));
//        Product save = productRepository.save(product);
//        return save;
//    }

    public ProductDTO create(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setDescription(productRequest.getDescription());
        Discount discount = restClient.get().uri("http://localhost:9090/api/v1/coupons/{couponName}", productRequest.getCouponCode()).retrieve().body(Discount.class); //خروجی یک دیسکانت است
        BigDecimal subTrack = new BigDecimal(100).subtract(discount.getCoupon());
        product.setPrice(subTrack.multiply(product.getPrice()).divide(new BigDecimal(100)));
        Product save = productRepository.save(product);
        ProductDTO dto = new ProductDTO(save.getName(), save.getCouponCode(), save.getPrice(), discount.getCoupon());
        return dto;
    }

}



