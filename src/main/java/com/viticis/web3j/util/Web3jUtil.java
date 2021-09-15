package com.viticis.web3j.util;

import com.viticis.web3j.model.ERC20;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

public class Web3jUtil {

    private static DefaultGasProvider defaultGasProvider = new DefaultGasProvider();

    public static ERC20 loadERC20Contract(String RpcGateWay, String contractAddress, String privateKey) throws Exception {
        ERC20 erc20 = ERC20.load(contractAddress, Web3j.build(new HttpService(RpcGateWay)), loadAccount(privateKey), defaultGasProvider);
        return erc20;
    }

    public static Credentials loadAccount(String privateKey) throws Exception {
        Credentials credentials = Credentials.create(privateKey);
        return credentials;
    }

    public static Credentials createAccount() throws Exception {
        ECKeyPair ecKeyPair = Keys.createEcKeyPair();
        Credentials credentials = Credentials.create(ecKeyPair);
        return credentials;
    }
}