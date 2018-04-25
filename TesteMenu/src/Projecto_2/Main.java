package Projecto_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		DisplayMenu();
	}
	
	public static void DisplayMenu() {
		
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
				Insert insert = new Insert();
				break;
			case "2":
				ListarTudo listarClientes = new ListarTudo();
				break;
			case "3":
				OpcoesCliente opcoesCliente = new OpcoesCliente();
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

}