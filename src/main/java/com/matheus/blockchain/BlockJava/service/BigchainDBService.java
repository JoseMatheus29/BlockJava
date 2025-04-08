package com.matheus.blockchain.BlockJava.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BigchainDBService {

    @Value("${bigchainDB.url}")
    private String bigchainDbUrl;

    private final RestTemplate restTemplate;

    public BigchainDBService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String registerData(String dataHash) {
        String payload = "{"
                + "\"asset\": {\"data\": {\"hash\": \"" + dataHash + "\"}},"
                + "\"operation\": \"CREATE\""
                + "}";

        String url = bigchainDbUrl + "transactions/";

        return restTemplate.postForObject(url, payload, String.class);
    }
}
