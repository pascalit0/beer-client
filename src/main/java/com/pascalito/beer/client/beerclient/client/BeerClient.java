package com.pascalito.beer.client.beerclient.client;

import com.pascalito.beer.client.beerclient.model.CustomerDTO;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Component
@ConfigurationProperties("beer.server")
@Data
public class BeerClient {
    private static final String CUSTOMER_API_PATH = "/api/v1/customers/";
    private String url;
    private final RestTemplate restTemplate;

    public BeerClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDTO getCustomer(Long id) {
        return restTemplate.getForObject(url + CUSTOMER_API_PATH + id, CustomerDTO.class);
    }

    public URI createCustomer(CustomerDTO customerDTO) {
        return restTemplate.postForLocation(url + CUSTOMER_API_PATH, customerDTO);
    }

    public void updateCustomer(Long id, CustomerDTO customerDTO) {
        restTemplate.put(url + CUSTOMER_API_PATH + id, customerDTO);
    }

    public void createCustomer(Long id) {
        restTemplate.delete(url + CUSTOMER_API_PATH + id);
    }
}
