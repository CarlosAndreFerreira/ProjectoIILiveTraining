package Projecto_2;

public class ContaOrdem extends Conta {
	
	//ATRIBUTOS
	
	protected Cliente cliente;
	protected CartaoDebito cartaoDebito;
	protected CartaoCredito cartaoCredito;
	
	//CONSTRUTORES
	
	ContaOrdem(Cliente cliente, double saldoInicial) {
		super(cliente, saldoInicial);
		System.out.println("Criada 'Conta à Ordem' | ID da conta: " + numeroDeConta + " | Data de criação : " + dataCriacao);
		cartaoDebito = new CartaoDebito(this);
		cliente.arrayContas.add(this);
	}
	
	//MÉTODOS

	public ContaOrdem getContaOrdem() {
		return this;
	}
	
	public int getContaID() {
		return numeroDeConta;
	}

}

