package Projecto_2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class OpcoesCliente {
	
	ContaOrdem contaOrdem;
	Cliente cliente;
	
	
	int clienteID;
	int contaID;
	int cartaoID;
	String tipo_de_cliente;
	
	public OpcoesCliente() {
	
	listarEspecifico();
	
	}
	
	private void listarEspecifico() {
		
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
			
			DisplayMenu();
		
		}catch (SQLException e) {
		System.out.println("Ocorreu o erro: " + e.getMessage());
		}finally {
		dbUtilities.DisconnectFromDB();
		}
	}
	
	private void DisplayMenu() {
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
				consultarSaldo();
				break;
			case "2":
				consultarMovimentos();
				break;
			case "3":
				realizarTransferencia();
				break;
			case "4":
				realizarLevantamento();
				break;
			case "5":
				realizarDeposito();
				break;
			case "6":
				cartaoDebito();
				break;
			case "7":
				System.out.println("Insira saldo inicial da conta: ");
				double saldoInicial = 0;
				Scanner inputSaldoInicial = new Scanner(System.in);
				saldoInicial = inputSaldoInicial.nextDouble();
				ContaPoupanca contaPoupanca = new ContaPoupanca(cliente, saldoInicial);
				break;
			case "8":
				
				break;
			case "9":
				CartaoDebito cartaoDebito = new CartaoDebito(contaOrdem);
				break;
			case "10":
				CartaoCredito cartaoCredito = new CartaoCredito(contaOrdem);
				break;
			case "11":
				Main.DisplayMenu();
				break;
			case "12":
				System.out.println("PROGRAMA TERMINADO. OBRIGADO.");
				System.exit(0);
				break;
			default:
				System.out.println("OPÇÃO INVÁLIDA!");
				break;
		}

	}


private void consultarSaldo() {
	
	for(ContaOrdem currCliente : contaOrdem.arrayContasOrdem) {
		if(currCliente.getContaID() == contaID) {
			System.out.println("O saldo é de: " + currCliente.getContaOrdem().getSaldo() + "€.");
			break;
		}
	}
	
	DisplayMenu();
}

private void consultarMovimentos() {
	
	for(ContaOrdem currCliente : contaOrdem.arrayContasOrdem) {
		if(currCliente.getContaID() == contaID) {
			currCliente.getContaOrdem().consultarMovimentos();
			break;
		}
	}
	
	DisplayMenu();
}

private boolean realizarDeposito() {
	
	double valor = 0;
	System.out.println("Insira quantia a depositar: ");
	Scanner valorDepositoInput = new Scanner(System.in);
	valor = valorDepositoInput.nextDouble();
	
	if (valor > 0) {
		for(ContaOrdem currCliente : contaOrdem.arrayContasOrdem) {
			if(currCliente.getContaID() == contaID) {
				currCliente.getContaOrdem().deposito(valor);
				break;
			}
		}
		DisplayMenu();
		return true;
	}else {
		System.out.println("Operação não efectuada. Valor inválido.");
		DisplayMenu();
		return false;
	}
}

private boolean realizarLevantamento() {
	
	double valor = 0;
	System.out.println("Insira quantia a levantar: ");
	Scanner valorLevantamentoInput = new Scanner(System.in);
	valor = valorLevantamentoInput.nextDouble();
	
	boolean executado = false;
	
	for(ContaOrdem currCliente : contaOrdem.arrayContasOrdem) {
		if(currCliente.getContaID() == contaID) {
			if (valor < currCliente.getContaOrdem().getSaldo()) {
				currCliente.getContaOrdem().levantamento(valor);
				executado = true;
				break;
			}else {
				System.out.println("Operação não pode ser efectuada. Saldo insuficiente");
			}
		}
	}
	
	DisplayMenu();
		
	if (executado) {
		return true;
	}else {
		return false;
	}
}

private boolean realizarTransferencia() {
	
	double valor = 0;
	int idDestino;
	
	System.out.println("Insira quantia a tranferir: ");
	Scanner valorTransferenciaInput = new Scanner(System.in);
	valor = valorTransferenciaInput.nextDouble();

	System.out.println("Insira ID do cliente destino: ");
	Scanner idDestinoInput = new Scanner(System.in);
	idDestino = idDestinoInput.nextInt();
	
	boolean levantamentoExecutado = false;
	boolean operacaoExecutada = false;
	
	for(ContaOrdem currClienteLevantamento : contaOrdem.arrayContasOrdem) {
		if(currClienteLevantamento.getContaID() == contaID) {
			if (valor < currClienteLevantamento.getContaOrdem().getSaldo()) {
				currClienteLevantamento.getContaOrdem().levantamento(valor);
				levantamentoExecutado = true;
				break;
			}else {
				System.out.println("Operação não pode ser efectuada. Saldo insuficiente");
			}
		}else {
			System.out.println("A conta especificada não foi encontrada.");
		}
	}
	
	if (levantamentoExecutado) {
		
		for(ContaOrdem currClienteDeposito : contaOrdem.arrayContasOrdem) {
			if(currClienteDeposito.getContaID() == idDestino) {
				currClienteDeposito.getContaOrdem().deposito(valor);
				operacaoExecutada = true;
				break;
			}
		}
	}
	
	DisplayMenu();
	
	if (operacaoExecutada) {
		return true;
	}else {
		return false;
	}
}

private void cartaoDebito() {
	
	Scanner userInputCartao = new Scanner(System.in);
	String readOption;
	
	System.out.println();
	System.out.println("OPÇÕES: ");
	System.out.println();
	System.out.println("1. Consultar saldo");
	System.out.println("2. Consultar movimentos");
	System.out.println("3. Realizar transferência");
	System.out.println("4. Realizar levantamento");
	System.out.println("5. Realizar depósito");
	System.out.println("6. Menu anterior");
	System.out.println("7. Menu Principal");
	System.out.println("8. Sair");
	System.out.println();
	System.out.println("ESCOLHA OPÇÃO: ");
	
	readOption = userInputCartao.next();
	
	switch (readOption) {
		case "1":
			consultarSaldo();
			break;
		case "2":
			consultarMovimentos();
			break;
		case "3":
			realizarTransferencia();
			break;
		case "4":
			realizarLevantamento();
			break;
		case "5":
			CartaoDebitoRealizarDeposito();
			break;
		case "6":
			DisplayMenu();
			break;
		case "7":
			Main.DisplayMenu();
			break;
		case "8":
			System.out.println("PROGRAMA TERMINADO. OBRIGADO.");
			System.exit(0);
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
			break;
	}
}
	
private void CartaoDebitoRealizarDeposito() {
		
	double valor = 0;
	System.out.println("Insira quantia a depositar: ");
	Scanner valorDepositoInput = new Scanner(System.in);
	valor = valorDepositoInput.nextDouble();
		
	if (valor > 0) {
		for(CartaoDebito currCliente : contaOrdem.cartaoDebito.arrayCartoesDebito) {
			if(currCliente.getCartaoDebitoID() == cartaoID) {
				currCliente.getCartaoDebito().deposito(valor);
				break;
			}
		}
		DisplayMenu();
			
	}else {
		System.out.println("Operação não efectuada. Valor inválido.");
		DisplayMenu();	
	}
}

}
