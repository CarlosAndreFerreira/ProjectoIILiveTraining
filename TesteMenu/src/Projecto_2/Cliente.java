package Projecto_2;

import java.util.ArrayList;

public abstract class Cliente {
	protected String titular;
	protected String profissao;
	protected String morada;
	protected int telefones;
	protected String email;
	protected String numeroCartaoCidadao;
	protected ContaOrdem contaOrdem;
	protected ContaPoupanca contaPoupanca;
	protected ContaPrazo contaPrazo;
	protected static int numeroDeCliente;
	protected String dataCriacao;
	
	ArrayList <Cliente> arrayClientes = new ArrayList<Cliente>();
	ArrayList <ClienteVip> arrayClientesVip = new ArrayList<ClienteVip>();
	
	public Cliente (String titular, String numeroCartaoCidadao, String morada, String profissao, int telefones, String email) {
		super();
		this.numeroCartaoCidadao = numeroCartaoCidadao;
		this.morada = morada;
		this.profissao = profissao;
		this.telefones = telefones;
		this.email = email;
		numeroDeCliente +=1;
		//arrayClientes.add(this);
	}
	
	public int getIdCliente() {
		return numeroDeCliente;
	}
	
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public ContaPoupanca getContaPoupanca() {
		return contaPoupanca;
	}
	public void setContaPoupanca(ContaPoupanca contaPoupanca) {
		this.contaPoupanca = contaPoupanca;
	}
	public ContaPrazo getContaPrazo() {
		return contaPrazo;
	}
	public void setContaPrazo(ContaPrazo contaPrazo) {
		this.contaPrazo = contaPrazo;
	}
}
