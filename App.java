package com.hubwiz.demo;

import wf.bitcoin.javabitcoindrpcclient.BitcoindRpcClient.Unspent;
import wf.bitcoin.javabitcoindrpcclient.BitcoinJSONRPCClient;
import java.util.*;

public class App{
	public static void main(String[] args) throws Exception {
		System.out.println("hello,bitcoinj");
	  	BitcoinJSONRPCClient client = new BitcoinJSONRPCClient("http://user:123456@127.0.0.1:18443");
		
      	double balance = client.getBalance();
		System.out.format("wallet balance => %f\n",balance);
		
		double amount = 0.;
		List<Unspent> utxos = client.listUnspent();
		for(Unspent utxo: utxos){
			amount += utxo.amount();
		}
		System.out.format("calculated balance => %f\n",amount);
	}
		
}

