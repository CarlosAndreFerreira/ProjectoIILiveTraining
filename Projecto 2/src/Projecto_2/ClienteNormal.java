package Projecto_2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ClienteNormal extends Cliente{
	
	protected ContaOrdem contaOrdem;
	protected ContaPoupanca contaPoupanca;
	protected ContaPrazo contaPrazo;
	
	ArrayList <ClienteNormal> arrayClientesNormal = new ArrayList<ClienteNormal>();
	
	public ClienteNormal(String titular, String numeroCartaoCidadao, String morada, String profissao, int telefones, String email, double saldoInicial) {
		
		super(titular, numeroCartaoCidadao, morada, profissao, telefones, email);
		dataCriacao = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE);
		System.out.println("Criado 'Cliente Normal' | ID Cliente: " + numeroDeCliente + " | Data de criação : " + dataCriacao);
		contaOrdem = new ContaOrdem(this, saldoInicial);
		arrayContas.add(contaOrdem);
		arrayClientesNormal.add(this);
	}
	
	public ContaOrdem getContaOrdem() {
		return this.contaOrdem;
	}

}
