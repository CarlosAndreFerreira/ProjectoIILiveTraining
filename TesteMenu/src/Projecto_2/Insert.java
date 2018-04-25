package Projecto_2;

import java.util.Scanner;

public class Insert {
	
	public Insert() {
		
		InsertData();
	}
	
	ClienteNormal clienteNormal;
	ClienteVip clienteVip;
	
	private void InsertData() {
		Scanner userInput1 = new Scanner (System.in);
		Scanner userInput2 = new Scanner (System.in);
		Scanner userInput3 = new Scanner (System.in);
		
		String tipo_de_cliente;
		String nome;
		String cc;
		String morada;
		String profissao;
		int telefones;
		String email;
		double saldoInicial;
		int contas;
		int cartoes;
		int contas_id;
		int cliente_id = 0;
		
		String stmt;
		String confirm;
		
		System.out.println("Introduzir tipo de cliente (N (Normal) / V (Vip)) : ");
		tipo_de_cliente = userInput1.nextLine().toUpperCase();
		
		System.out.println("Introduzir titular: ");
		nome = userInput1.nextLine();
		
		System.out.println("Introduzir cartao de cidadão: ");
		cc = userInput1.nextLine();
		
		System.out.println("Introduzir morada: ");
		morada = userInput1.nextLine();
		
		System.out.println("Introduzir profissão: ");
		profissao = userInput1.nextLine();
		
		System.out.println("Introduzir telefones: ");
		telefones = userInput2.nextInt();
		
		System.out.println("Introduzir eMail: ");
		email = userInput1.nextLine();
		
		System.out.println("Introduzir saldo inicial da conta à ordem: ");
		saldoInicial = userInput2.nextDouble();
		
		contas = Conta.numeroDeConta+1;
		
		cartoes = Cartao.numeroDeCartao+1;
		
		contas_id = Conta.numeroDeConta+1;
		
		System.out.println("Dados do cliente a inserir: ");
		System.out.println("Tipo de cliente: " + tipo_de_cliente);
		System.out.println("Titular: " + nome);
		System.out.println("Cartão de cidadão: " + cc);
		System.out.println("Morada: " + morada);
		System.out.println("Profissão: " + profissao);
		System.out.println("Telefones: " + telefones);
		System.out.println("Email: " + email);
		System.out.println("Saldo inicial da conta à ordem: " + saldoInicial);
		System.out.println();
		
		System.out.println("Inserir \"s\" ou \"S\" para confirmar dados do actor.");
		confirm = userInput3.next();
		
		if ("S".equalsIgnoreCase(confirm)) {
			
			if ("N".equalsIgnoreCase(tipo_de_cliente)) {
				
				ClienteNormal clienteNormalBase = new ClienteNormal(nome, cc, morada, profissao, telefones, email, saldoInicial);
				this.clienteNormal = clienteNormalBase;
				cliente_id = clienteNormal.getIdCliente();
				
			}else if ("V".equalsIgnoreCase(tipo_de_cliente)) {
				
				ClienteVip clienteVipBase = new ClienteVip(nome, cc, morada, profissao, telefones, email, saldoInicial);
				this.clienteVip = clienteVipBase;
				cliente_id = clienteVip.getIdCliente();
				
			}else {
				System.out.println("Erro ao digitar tipo de cliente.");
			}
			
			DbUtilities dbutilities = new DbUtilities();

			stmt = "INSERT INTO dbbanco.Cliente VALUES ('" + cliente_id + "','" + tipo_de_cliente + "','" + nome + "','" + cc + "','" + morada + "','" + profissao +"','" + telefones + "','"+ email + "','" + contas + "','" + cartoes + "','" + contas_id + "')";

			dbutilities.ExecuteSqlStatement(stmt);
			
			System.out.println("O registo foi inserido com sucesso");
			System.out.println();
		
		}else
			System.out.println("Opção inválida.");
		
	Main.DisplayMenu();
	
	}
}