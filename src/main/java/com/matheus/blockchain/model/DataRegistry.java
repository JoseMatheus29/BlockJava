package com.matheus.blockchain.model;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

public class DataRegistry extends Contract {
    
    protected DataRegistry(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider gasProvider) {
        super("", contractAddress, web3j, credentials, gasProvider);
    }

    public RemoteCall<TransactionReceipt> registerData(String dataHash) {
        Function function = new Function(
            "registerData",
            Arrays.asList(new Utf8String(dataHash)),
            Collections.emptyList()
        );
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getDataHash() {
        Function function = new Function(
            "getDataHash",
            Collections.emptyList(),
            Arrays.asList(new TypeReference<Utf8String>() {})
        );
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static DataRegistry load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider gasProvider) {
        return new DataRegistry(contractAddress, web3j, credentials, gasProvider);
    }
} 