package Projecto_2;

public class ContaOrdem extends Conta {
	
	//ATRIBUTOS
	
	protected Cliente cliente;
	protected CartaoDebito cartaoDebito;
	protected CartaoCredito cartaoCredito;
	
	//CONSTRUTORES
	
	ContaOrdem(Cliente cliente, double saldoInicial) {
		super(cliente, saldoInicial);
		this.cliente = cliente;
		System.out.println("Criada 'Conta � Ordem' | ID da conta: " + numeroDeConta + " | Data de cria��o : " + dataCriacao);
		cartaoDebito = new CartaoDebito(this);
	}
	
	//M�TODOS

	public ContaOrdem getContaOrdem() {
		return this;
	}
	
	public int getContaID() {
		return numeroDeConta;
	}

}

