package com.matheus.blockchain.BlockJava.controller;

import com.matheus.blockchain.BlockJava.service.BigchainDBService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    private final BigchainDBService bigchainDBService;

    public RegistroController(BigchainDBService bigchainDBService) {
        this.bigchainDBService = bigchainDBService;
    }

    @PostMapping
    public String registrar(@RequestBody String data) {
        String dataHash = generateHash(data);
        return bigchainDBService.registerData(dataHash);
    }

    private String generateHash(String data) {
        return Integer.toHexString(data.hashCode());
    }
}
