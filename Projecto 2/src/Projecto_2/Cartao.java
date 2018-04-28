package Projecto_2;

public abstract class Cartao {
	
	protected static int numeroDeCartao;			
	protected ContaOrdem contaordem;
	protected ContaOrdem contaDestino;
	protected int numeroCartao;
	protected String dataCriacao;
	protected Movimentos movimento;
	
	public Cartao(ContaOrdem contaOrdem) {
		numeroDeCartao += 1;
		this.contaordem = contaOrdem;
	}
	
	public void deposito (double valor) {
		this.contaordem.deposito(valor);
	}
	
	public void levantamento (double valor) {
		this.contaordem.levantamento(valor);	
	}
	
	public void transferencia (ContaOrdem contaordem, double valor) {
		this.contaordem.transfere(contaDestino, valor);
	}
	
	public void getSaldo () {
		this.contaordem.getSaldo();
	}	
	
}
