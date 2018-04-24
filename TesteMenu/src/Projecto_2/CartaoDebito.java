package Projecto_2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CartaoDebito extends Cartao {
	
	ArrayList <CartaoDebito> arrayCartoesDebito = new ArrayList<CartaoDebito>();

	public CartaoDebito(ContaOrdem contaOrdem) {
		super(contaOrdem);
		dataCriacao = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
		System.out.println("Criado 'Cart�o de D�bito' | ID Cart�o: " + numeroDeCartao + " | Data de cria��o : " + dataCriacao);
		arrayCartoesDebito.add(this);
	}

	public int getNumeroCartao() {
		return numeroCartao;
	}
	
	public CartaoDebito getCartaoDebito() {
		return this;
	}
	
	public int getCartaoDebitoID() {
		return numeroDeCartao;
	}
	

}

