package Projecto_2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ClienteVip extends Cliente{
	
	String referenciaInterna = "CV." + Cliente.numeroDeCliente;
	
	protected ContaOrdem contaOrdem;
	protected ContaPoupanca contaPoupanca;
	protected ContaPrazo contaPrazo;

	public ClienteVip(String titular, String numeroCartaoCidadao, String morada, String profissao, int telefones, String email, double saldoInicial) {
		super(titular, numeroCartaoCidadao, morada, profissao, telefones, email);
		dataCriacao = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
		System.out.println("Criado 'Cliente Vip' | ID Cliente: " + numeroDeCliente + " | Data de criação : " + dataCriacao);
		contaOrdem = new ContaOrdem(this, saldoInicial);
		contaOrdem.arrayContasOrdem.add(contaOrdem);
		arrayClientesVip.add(this);
		arrayClientes.add(this);
	}
	
	public String getReferenciaInterna() {
		return this.referenciaInterna;
	}
	
	public ContaOrdem getContaOrdem() {
		return this.contaOrdem;
	}
	
	

}
