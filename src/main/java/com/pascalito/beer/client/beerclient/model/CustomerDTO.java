package com.pascalito.beer.client.beerclient.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Builder
public class CustomerDTO {
    private final long id;
    private final String name;
}
