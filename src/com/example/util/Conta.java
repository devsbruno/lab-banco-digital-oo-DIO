package com.example.util;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int sequencial = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    protected Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = sequencial++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
			System.out.println("Saldo Atual: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para saque.");
			System.out.println("Saldo Atual: " + saldo);
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
		System.out.println("Deposito de: " + valor + " Realizado");
		System.out.println("Saldo Atual: " + saldo);
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        if (valor <= saldo) {
            this.sacar(valor);
            contaDestino.depositar(valor);
			System.out.println("Transferencia de: " + valor + " Realizada");
			System.out.println("Saldo Atual: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para transferência.");
			System.out.println("Saldo Atual: " + saldo);
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}
