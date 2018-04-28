package Projecto_2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ClienteVip extends Cliente{
	
	protected ContaOrdem contaOrdem;
	protected ContaPoupanca contaPoupanca;
	protected ContaPrazo contaPrazo;

	public ClienteVip(String titular, String numeroCartaoCidadao, String morada, String profissao, int telefones, String email, double saldoInicial) {
		super(titular, numeroCartaoCidadao, morada, profissao, telefones, email);
		dataCriacao = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
		System.out.println("Criado 'Cliente Vip' | ID Cliente: " + numeroDeCliente + " | Data de cria��o : " + dataCriacao);
		contaOrdem = new ContaOrdem(this, saldoInicial);
		arrayContas.add(contaOrdem);
	}
	
	public ContaOrdem getContaOrdem() {
		return this.contaOrdem;
	}
	
	

}
