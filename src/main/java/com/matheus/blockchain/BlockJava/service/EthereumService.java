package com.matheus.blockchain.BlockJava.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.crypto.Credentials;
import com.matheus.blockchain.model.DataRegistry;

@Service
public class EthereumService {

    private final Web3j web3j;
    private final String contractAddress;
    private final String infuraProjectId;

    public EthereumService(
            @Value("${infura.project.id}") String infuraProjectId,
            @Value("${contract.address}") String contractAddress) {
        this.infuraProjectId = infuraProjectId;
        this.contractAddress = contractAddress;
        this.web3j = Web3j.build(new HttpService("https://mainnet.infura.io/v3/" + infuraProjectId));
    }

    public void registerData(String dataHash, String privateKey) throws Exception {
        Credentials credentials = Credentials.create(privateKey);
        DataRegistry contract = DataRegistry.load(contractAddress, web3j, credentials, new DefaultGasProvider());
        contract.registerData(dataHash).send();
    }

    public String getDataHash() throws Exception {
        DataRegistry contract = DataRegistry.load(contractAddress, web3j, Credentials.create("0x0000000000000000000000000000000000000000000000000000000000000000"), new DefaultGasProvider());
        return contract.getDataHash().send();
    }
}
