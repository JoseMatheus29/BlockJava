package com.matheus.blockchain.BlockJava.controller;
import com.matheus.blockchain.BlockJava.service.EthereumService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registro")
public class RegistroController {

    private final EthereumService ethereumService;

    public RegistroController(EthereumService ethereumService) {
        this.ethereumService = ethereumService;
    }

    @PostMapping
    public String registrar(@RequestBody String data) {
        String dataHash = generateHash(data);
        try {
            ethereumService.registerData(dataHash, "yourPrivateKeyHere");
            return "Dado registrado no Ethereum!";
        } catch (Exception e) {
            return "Erro: " + e.getMessage();
        }
    }

    private String generateHash(String data) {
        return Integer.toHexString(data.hashCode());
    }
}