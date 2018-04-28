package Projecto_2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
	
	public Update() {
		Scanner userInput1 = new Scanner (System.in);
		Scanner userInput2 = new Scanner (System.in);
		Scanner userInput3 = new Scanner (System.in);
		
		int cliente_id;
		String nome;
		String tipo_de_cliente;
		String cc;
		String morada;
		int telefones;
		String email;
		String profissao;
		int contas;
		int cartoes;
		int contas_id;
		String stmt;
		String confirm;
		
		System.out.println("Selecionou a opção 3");
		System.out.println();
		System.out.println("Introduzir o identificador do cliente a atualizar:");
		
		cliente_id = userInput1.nextInt();
		
		DisplayRecord(cliente_id);
		System.out.println();
		
		System.out.println("Introduzir novo titular: ");
		nome = userInput2.nextLine();
		
		System.out.println("Introduzir tipo de cliente: ");
		tipo_de_cliente = userInput2.nextLine();
		
		System.out.println("Introduzir cartão de cidadão: ");
		cc = userInput2.nextLine();
		
		System.out.println("Introduzir morada: ");
		morada = userInput2.nextLine();
		
		System.out.println("Introduzir telefones: ");
		telefones = userInput1.nextInt();
		
		System.out.println("Introduzir email: ");
		email = userInput2.nextLine();
		
		System.out.println("Introduzir profissão: ");
		profissao = userInput2.nextLine();
		
		System.out.println("Introduzir contas: ");
		contas = userInput1.nextInt();
		
		System.out.println("Introduzir cartões: ");
		cartoes = userInput1.nextInt();
		
		System.out.println("Introduzir ID das contas: ");
		contas_id = userInput1.nextInt();
		
		System.out.println();
		System.out.println("Dados do cliente a atualizar: ");
		System.out.println();
		System.out.println("ID do Actor: " + cliente_id);
		System.out.println("Nome: " + nome);
		System.out.println("Tipo de cliente: " + tipo_de_cliente);
		System.out.println("Morada: " + morada);
		System.out.println("Telefones: " + telefones);
		System.out.println("Profissão: " + profissao);
		System.out.println("Contas: " + contas);
		System.out.println("Cartões: " + cartoes);
		System.out.println("ID das contas: " + contas_id);
		System.out.println();
		
		System.out.println("Inserir \"s\" ou \"S\" para confirmar dados do actor a atualizar.");
		confirm = userInput3.next();
		
		if ("S".equalsIgnoreCase(confirm)) {
			DbUtilities dbutilities = new DbUtilities();
			stmt = "UPDATE dbbanco.Cliente SET cliente_id = '" + cliente_id + "', nome = '" + nome + "', tipo_de_cliente = '" + tipo_de_cliente + "', cc = '" + cc + "', morada = '" + morada + "', telefones = '" + telefones + "', email = '" + email + "', profissão = '" + profissao + "', contas = '" + contas + "', cartões = '" + cartoes + "', contas_id = '" + contas_id + "' WHERE cliente_id = '" + cliente_id + "'";
			
			//"UPDATE sakila.actor SET first_name = '" + first_name + "', last_name = '" + last_name + "', last_update = '" + last_update + "' WHERE actor_id = '" + actor_id + "'";
			
			dbutilities.ExecuteSqlStatement(stmt);
			
			System.out.println("O registo foi atualizado com sucesso");
			System.out.println();
		}
		
		Main.display();
	}
	
	private void DisplayRecord (int cliente_id) {
		DbUtilities dbutilities = new DbUtilities();
		String stmt = "SELECT * FROM dbbanco.Cliente WHERE cliente_id = " + cliente_id;
		ResultSet rs = dbutilities.ReadRecords(stmt);
		
		try {
			if (rs.next()) {
				do {
					System.out.println(rs.getInt(1) + " " + ""+ rs.getString(2)+"" + " "+ rs.getString(3)+" "+" " +" "+ rs.getString(4) +" "+"" + rs.getString(5) +" "+ rs.getInt(6) + " "+ rs.getString(7) +" "+ rs.getString(8)+ " "+ rs.getInt(9)+ " "+ rs.getInt(10)+ rs.getInt(11));
				}while (rs.next());
			}else
				System.out.println("Não há registos.");
		} catch (SQLException e) {
			System.out.println("Ocorreu o erro: " + e.getMessage());
		}
	}
}
