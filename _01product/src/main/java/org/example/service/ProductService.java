package org.example.service;

import org.example.discount.DiscountClient;
import org.example.discount.DiscountRequest;
import org.example.dto.ProductDTO;
import org.example.product.ProductRequest;
import org.example.entity.Product;
import org.example.notification.NotificationClient;
import org.example.notification.NotificationRequest;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import javax.management.Notification;
import java.math.BigDecimal;

@Service
public class ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestClient.Builder restClient;

    @Autowired
    private DiscountClient discountClient;

    @Autowired
    private NotificationClient notificationClient;


//    @Autowired
//    private RestTemplate restTemplate;

//    public Product create(Product product) {
//        DiscountRequest discount = restTemplate.getForObject("http://localhost:9090/api/v1/coupons/{couponName}", DiscountRequest.class, product.getCouponCode());
//        BigDecimal subTrack = new BigDecimal(100).subtract(discount.getCoupon());
//        product.setPrice(subTrack.multiply(product.getPrice()).divide(new BigDecimal(100)));
//        Product save = productRepository.save(product);
//        return save;
//    }

//    public Product create(Product product) {
//        DiscountRequest discount = restClient.get().uri("http://localhost:9090/api/v1/coupons/{couponName}", product.getCouponCode()).retrieve().body(DiscountRequest.class);
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
        DiscountRequest discount = discountClient.getDiscount(productRequest.getCouponCode());
        BigDecimal subTrack = new BigDecimal(100).subtract(discount.getCoupon());
        product.setPrice(subTrack.multiply(product.getPrice()).divide(new BigDecimal(100)));
        Product save = productRepository.save(product);
        ProductDTO dto = new ProductDTO(save.getName(), save.getCouponCode(), save.getPrice(), discount.getCoupon());

//        todo dend notification
        NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setProductId(save.getId());
        notificationRequest.setMessage(String.format("product with id %s saved", save.getId()));
        notificationClient.sendNotification(notificationRequest);
        return dto;
    }


//    public DiscountRequest getDiscount(ProductRequest productRequest) {
//        return restClient.build()
//                .get()
//                .uri("http://DISCOUNT/api/v1/coupons/{couponName}", productRequest.getCouponCode())
//                .retrieve()
//                .body(DiscountRequest.class);
//    }

}



