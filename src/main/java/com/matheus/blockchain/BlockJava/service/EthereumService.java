package com.matheus.blockchain.BlockJava.service;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.crypto.Credentials;
import org.web3j.generated.Contract;

public class EthereumService {

    private final Web3j web3j;
    private final String contractAddress = "0xYourContractAddress"; // Endereço do contrato implantado

    public EthereumService() {
        // Configura o Web3j para usar o endpoint do Infura
        web3j = Web3j.build(new HttpService("https://mainnet.infura.io/v3/YOUR_INFURA_PROJECT_ID"));
    }

    // Função para registrar um hash no contrato
    public void registerData(String dataHash, String privateKey) throws Exception {
        // Carregar credenciais (sua chave privada)
        Credentials credentials = Credentials.create(privateKey);

        // Carregar o contrato inteligente
        DataRegistry contract = DataRegistry.load(contractAddress, web3j, credentials, new DefaultGasProvider());

        // Enviar transação para registrar o hash
        contract.registerData(dataHash).send();
    }

    // Função para consultar o hash registrado
    public String getDataHash() throws Exception {
        DataRegistry contract = DataRegistry.load(contractAddress, web3j, new DefaultGasProvider());
        return contract.getDataHash().send();
    }
}
