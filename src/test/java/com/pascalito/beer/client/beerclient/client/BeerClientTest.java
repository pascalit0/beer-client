package com.pascalito.beer.client.beerclient.client;

import com.pascalito.beer.client.beerclient.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerClientTest {

    @Autowired
    BeerClient beerClient;

    @Test
    void getCustomer() {
        var sampleDto = CustomerDTO.builder()
                .id(1L)
                .build();
        assertEquals(sampleDto, beerClient.getCustomer(1L));
    }

    @Test
    void createCustomer() {
        var sampleDto = CustomerDTO.builder()
                .name("MyCustomer")
                .build();

        var resultURI = URI.create("/api/v1/customers/1");
        assertEquals(resultURI, beerClient.createCustomer(sampleDto));
    }

    @Test
    void updateCustomer() {
        var sampleDto = CustomerDTO.builder()
                .id(1L)
                .build();
        beerClient.updateCustomer(1L, sampleDto);
    }
}