package com.example.util;

public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente(null, null, null, null);
		venilton.setNome("Venilton");
		venilton.setCpf("00000000000000");
		venilton.setEndereco("Rua almerinda");
		venilton.setTelefone("2198888-8888");
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
