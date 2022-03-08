package com.pascalito.beer.client.beerclient.client;

import com.pascalito.beer.client.beerclient.model.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}