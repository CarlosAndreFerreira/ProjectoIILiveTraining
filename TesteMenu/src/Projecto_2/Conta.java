package Projecto_2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

abstract class Conta {
	
	//ATRIBUTOS
	protected static int numeroDeConta;
	protected static int totalDeContas;
	protected static int numeroMovimento = 1;
	protected LocalDate dataCriacao;
	protected Movimentos movimento;
	protected LocalDate dataAposAno;
	protected Cliente cliente;
	
	protected double saldo;

	ArrayList <Movimentos> arrayMovimentos = new ArrayList<Movimentos>();
	
	ArrayList <ContaOrdem> arrayContasOrdem = new ArrayList<ContaOrdem>();
	
	//CONSTRUTOR
	Conta(Cliente cliente, double saldoInicial) {
		numeroDeConta += 1;
		totalDeContas += 1;
		dataCriacao = LocalDate.now();
		this.saldo = saldoInicial;
		this.cliente = cliente;
		dataAposAno = LocalDate.now().plusDays(365);
	}
	
	void levantamento(double valor) {
		this.saldo -= valor;
		System.out.println("Operação efectuada. Saldo = " + this.saldo + "€.");
		movimento = new Movimentos(valor, "Levantamento", "Conta à Ordem", LocalDate.now());
		arrayMovimentos.add(movimento);
		numeroMovimento++;
	}

	void deposito(double valor) {
		this.saldo += valor;
		System.out.println("Operação efectuada. Saldo = " + this.saldo + "€");
		movimento = new Movimentos(valor, "Depósito", "Conta à Ordem", LocalDate.now());
		arrayMovimentos.add(movimento);
		numeroMovimento++;
	}

	void transfere(ContaOrdem destino, double valor) {
		this.levantamento(valor);
		destino.deposito(valor);
		movimento = new Movimentos(valor, "Transferência", "Conta à Ordem", LocalDate.now());
		arrayMovimentos.add(movimento);
		numeroMovimento++;
	}

	public LocalDate getdataCriacao() {
		return dataCriacao;
	}
	
	public void consultarMovimentos() {
		for (Movimentos movimento : arrayMovimentos) {
			movimento.mostraMovimentos();
		}
	}
	
	public void setSaldo(double saldo) {
		if (saldo > 0) {
			this.saldo = saldo;
		}else {
			System.out.println("Operação não efectuada. Valor inválido.");
		}
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public static int getNumeroDeConta() {
		return numeroDeConta;
	}

}
