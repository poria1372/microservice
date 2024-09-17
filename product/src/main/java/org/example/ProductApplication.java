package org.example;


import org.hibernate.annotations.Bag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProductApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Bean
    public RestClient restClient(){ //جهت برقراری ارتباط با دیسکانت
        return RestClient.builder().build();
    }

//    @Bean
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
}
