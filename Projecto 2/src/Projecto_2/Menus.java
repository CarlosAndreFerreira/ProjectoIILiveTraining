package Projecto_2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menus {
	
	public Menus() {
		
		DisplayMenu();
	}
	
	Cliente cliente;
	
	ArrayList <Cliente> arrayClientes = new ArrayList<Cliente>();
	
	public void DisplayMenu() {
		
		Scanner userInput = new Scanner(System.in);
		String readOption;
		
		System.out.println();
		System.out.println("OPÇÕES:");
		System.out.println();
		System.out.println("1. Criar cliente");
		System.out.println("2. Listar clientes");
		System.out.println("3. Opções do cliente");
		System.out.println("4. Seleccionar um cartão");
		System.out.println("5. Avançar um período");
		System.out.println("6. Atualizar cliente");
		System.out.println("7. Apagar cliente");
		System.out.println("8. Sair");
		System.out.println();
		System.out.println("ESCOLHA UMA OPÇÃO:");
		readOption = userInput.next();
		
		switch (readOption) {
			case "1":
				InsertData();
				break;
			case "2":
				ListarTudo listarClientes = new ListarTudo();
				break;
			case "3":
				OpcoesCliente();
				break;
			case "6":
				Update update = new Update();
				break;
			case "7":
				Delete deleteCliente = new Delete();
				break;
			case "8":
				System.out.println("O programa será encerrado. Obrigado.");
				System.exit(0);
				break;
			default:
				System.out.println("Opção inválido!");
				break;
		}

	}
	
	public void InsertData() {
		
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
				
				Cliente clienteNormal = new ClienteNormal(nome, cc, morada, profissao, telefones, email, saldoInicial);
				arrayClientes.add(clienteNormal);
				cliente_id = clienteNormal.getIdCliente();
				this.cliente = clienteNormal;
				
			}else if ("V".equalsIgnoreCase(tipo_de_cliente)) {
				
				Cliente clienteVip = new ClienteVip(nome, cc, morada, profissao, telefones, email, saldoInicial);
				arrayClientes.add(clienteVip);
				cliente_id = clienteVip.getIdCliente();
				this.cliente = clienteVip;
				
			}else {
				System.out.println("Erro ao digitar tipo de cliente.");
			}
			
			arrayClientes.add(this.cliente);
			
			DbUtilities dbutilities = new DbUtilities();

			stmt = "INSERT INTO dbbanco.Cliente VALUES ('" + cliente_id + "','" + tipo_de_cliente + "','" + nome + "','" + cc + "','" + morada + "','" + profissao +"','" + telefones + "','"+ email + "','" + contas + "','" + cartoes + "','" + contas_id + "')";

			dbutilities.ExecuteSqlStatement(stmt);
			
			System.out.println("O registo foi inserido com sucesso");
			System.out.println();
		
		}else
			System.out.println("Opção inválida.");
		
		Main.display();
	
	}
	
	public void OpcoesCliente() {
		
		int clienteID = 0;
		int contaID = 0;
		int cartaoID = 0;
		String tipo_de_cliente;
			
			Scanner scanner = new Scanner(System.in);
			DbUtilities dbUtilities = new DbUtilities();
			String stmt;
			ResultSet rs;
			
			while (clienteID == 0 || clienteID > Cliente.numeroDeCliente) {
			
				System.out.println("DIGITE 'ID' DO CLIENTE (Clientes na B.D. -> " + Cliente.numeroDeCliente + ")");
			
				clienteID = scanner.nextInt();
			}
			
			try {

				stmt = "SELECT cliente_id, tipo_de_cliente, nome, cc, morada, profissão, telefones, email, contas, cartões, contas_id From dbbanco.Cliente WHERE cliente_id = " + clienteID;
				rs = dbUtilities.ReadRecords(stmt);
			
				System.out.println("DADOS DO CLIENTE: ");
			
				while(rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getInt(7) + " " + rs.getString(8) + " " + rs.getInt(9) + " " + rs.getInt(10) + " " + rs.getInt(11));
				
				tipo_de_cliente = (rs.getString(2));
				contaID = (rs.getInt(10));
				cartaoID = (rs.getInt(11));
				
				}
				
				Scanner userInput = new Scanner(System.in);
				String readOption;
				
				System.out.println();
				System.out.println("OPÇÕES: ");
				System.out.println();
				System.out.println("1. Consultar saldo");
				System.out.println("2. Consultar movimentos");
				System.out.println("3. Realizar transferência");
				System.out.println("4. Realizar levantamento");
				System.out.println("5. Realizar depósito");
				System.out.println("6. Aceder a cartão de débito");
				System.out.println("7. Criar Conta Poupança");
				System.out.println("8. Criar Conta Prazo");
				System.out.println("9. Criar Cartão Débito");
				System.out.println("10. Criar Cartão Crédito");
				System.out.println("11. Menu Principal");
				System.out.println("12. Sair");
				System.out.println();
				System.out.println("ESCOLHA OPÇÃO: ");
				
				readOption = userInput.next();
				
				switch (readOption) {
					case "1": 
						consultarSaldo(contaID);
						break;
					case "2":
						//consultarMovimentos();
						break;
					case "3":
						//realizarTransferencia();
						break;
					case "4":
						//realizarLevantamento();
						break;
					case "5":
						//realizarDeposito();
						break;
					case "6":
						//cartaoDebito();
						break;
					case "7":
						System.out.println("Insira saldo inicial da conta: ");
						double saldoInicial = 0;
						Scanner inputSaldoInicial = new Scanner(System.in);
						saldoInicial = inputSaldoInicial.nextDouble();
						//ContaPoupanca contaPoupanca = new ContaPoupanca( saldoInicial);
						break;
					case "8":
						
						break;
					case "9":
						//CartaoDebito cartaoDebito = new CartaoDebito();
						break;
					case "10":
						//CartaoCredito cartaoCredito = new CartaoCredito();
						break;
					case "11":
						Main.display();
						break;
					case "12":
						System.out.println("PROGRAMA TERMINADO. OBRIGADO.");
						System.exit(0);
						break;
					default:
						System.out.println("OPÇÃO INVÁLIDA!");
						break;
				}

			
			}catch (SQLException e) {
			System.out.println("Ocorreu o erro: " + e.getMessage());
			}finally {
			dbUtilities.DisconnectFromDB();
			}
		}
	
	public void consultarSaldo(int contaID) {
		
		// A arrayList já deveria ter um elemento do tipo Cliente (poderá ser normal ou vip) mas está vazia, como comprova o método seguinte: 
		System.out.println(arrayClientes.isEmpty());
		
		for(Cliente currCliente : arrayClientes) {
			if(((ClienteNormal) currCliente).getContaOrdem().getContaID() == contaID) {
				System.out.println("O saldo é de: " + ((ClienteNormal) currCliente).getContaOrdem().getSaldo() + "€.");
				break;
			}
		}
		Main.display();
	}

}
