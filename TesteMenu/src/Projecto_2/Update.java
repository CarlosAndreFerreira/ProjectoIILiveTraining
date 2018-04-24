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
		
		Main.DisplayMenu();
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
	
/*	public Update() {
		
		Scanner userInput = new Scanner(System.in);
		Scanner userInput3 = new Scanner(System.in);
		
	     System.out.println("Selecionou a opção 3: Atualiza dados de um cliente: ");

	     String cliente_id;
	     System.out.println(" Insira o cliente_id: ");
	     cliente_id = userInput.next();

	     String nome;
	     System.out.println("Insira o nome: ");
	     nome = userInput.next();

	     String tipo_de_cliente;
	     System.out.println("Insira o tipo_de_cliente: ");
	     tipo_de_cliente = userInput.next();
	     
	     String cc;
	     System.out.println("Insira o cartao de cidadao: ");
	     cc = userInput.next();
	     
	     String morada;
	     System.out.println("Insira o sua morada: ");
	     morada = userInput.next();
	     
	     String telefones;
	     System.out.println("Insira o seu numero de telefone: ");
	     telefones= userInput.next();
	     
	     String email;
	     System.out.println("Insira o seu email: ");
	     email = userInput.next();
	     
	     String profissao;
	     System.out.println("Insira a sua profissao: ");
	     profissao = userInput.next();
	     
	     String contas;
	     System.out.println("Insira o numero de contas: ");
	     contas = userInput.next();
	     
	     String cartoes;
	     System.out.println("Insira o numero de cartoes: ");
	     cartoes = userInput.next();
		
		//System.out.println();
		//System.out.println("Dados do actor a atualizar: ");
		//System.out.println();
		//System.out.println("ID do Actor: " + actor_id);
		//System.out.println("First Name: " + first_name);
		//System.out.println("Last Name: " + last_name);
		//System.out.println("Last Update: " + last_update);
		//System.out.println();
		
		System.out.println("Inserir \"s\" ou \"S\" para confirmar dados do actor a atualizar.");
		String confirm;
		confirm = userInput3.next();
		
		if ("S".equalsIgnoreCase(confirm)) {
			DbUtilities dbutilities = new DbUtilities();
			 String stmt = "UPDATE bancoDb.Cliente SET cliente_id = '"  + cliente_id  + "',Nome = '" + nome + "',Tipo de Cliente = '" + tipo_de_cliente+ "',Cartao cidadao = "+ cc +"',Morada = "+ morada+ "',Telefones = "+ telefones+ "',Email = "+ email+ "',Profissão = "+profissao+"',Contas = "+contas+ "',Cartoes = "+ cartoes + "' WHERE id = " + cliente_id;
			
			dbutilities.ExecuteSqlStatement(stmt);
			
			System.out.println("O registo foi atualizado com sucesso");
			System.out.println();
		}
		
		Main.DisplayMenu();
	}
	
	private void DisplayRecord (int cliente_id) {
		DbUtilities dbutilities = new DbUtilities();
		String stmt = "SELECT * FROM dbbanco.Cliente WHERE cliente_id = " + cliente_id;
		ResultSet rs = dbutilities.ReadRecords(stmt);
		
		try {
			if (rs.next()) {
				do {
					System.out.println(rs.getInt(1)+" " + ""+ rs.getString(2)+""+" "+ rs.getString(3)+" "+" " +" "+ rs.getString(4) +" "+"" + rs.getString(5) +" "+ rs.getInt(6) + " "+ rs.getString(7) +" "+ rs.getString(8)+ " "+ rs.getInt(9)+ " "+ rs.getInt(10)+ rs.getInt(11));
				}while (rs.next());
			}else
				System.out.println("Não há registos.");
		} catch (SQLException e) {
			System.out.println("Ocorreu o erro: " + e.getMessage());
		}
	}
}


package basedados;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class Update {
	public Update() {
	 Scanner userInput = new Scanner(System.in);
     System.out.println("Selecionou a opção 3: Atualiza dados de um cliente: ");

     String cliente_id;
     System.out.println(" Insira o cliente_id: ");
     cliente_id = userInput.next();

     String nome;
     System.out.println("Insira o nome: ");
     nome = userInput.next();

     String tipo_de_cliente;
     System.out.println("Insira o tipo_de_cliente: ");
     tipo_de_cliente = userInput.next();
     
     String cc;
     System.out.println("Insira o cartao de cidadao: ");
     cc = userInput.next();
     
     String morada;
     System.out.println("Insira o sua morada: ");
     morada = userInput.next();
     
     String telefones;
     System.out.println("Insira o seu numero de telefone: ");
     telefones= userInput.next();
     
     String email;
     System.out.println("Insira o seu email: ");
     email = userInput.next();
     
     String profissao;
     System.out.println("Insira a sua profissao: ");
     profissao = userInput.next();
     
     String contas;
     System.out.println("Insira o numero de contas: ");
     contas = userInput.next();
     
     String cartoes;
     System.out.println("Insira o numero de cartoes: ");
     cartoes = userInput.next();
     
     
     
     Dbutilities dbUtilities = new Dbutilities();

     String stmt = "UPDATE bancoDb.Cliente SET cliente_id = '"  + cliente_id  + "',Nome = '" + nome + "',Tipo de Cliente = '" + tipo_de_cliente+ "',Cartao cidadao = "+ cc +"',Morada = "+ morada+ "',Telefones = "+ telefones+ "',Email = "+ email+ "',Profissão = "+profissao+"',Contas = "+contas+ "',Cartoes = "+ cartoes + "' WHERE id = " + cliente_id;

     dbUtilities.ExecuteSqlStatemenr(stmt);

     System.out.println("O cliente foi apagado com cucesso");

     Main.DisplayMenu();
 }

 private void DisplayRecord(String cliente_id)  {
     try {
         Dbutilities dbUtilities = new Dbutilities();

         String stmt = "SELECT * FROM sakila.actor WHERE id = " + cliente_id;
         ResultSet rs = dbUtilities.ReadRecords(stmt);
         
         
         
         if (rs.next()) {

             ResultSetMetaData metaData = rs.getMetaData();
             int numberOfColumns = metaData.getColumnCount();
             System.out.print("Database Records Listingn");

             for (int i = 1; i <= numberOfColumns; i++) {
                 System.out.printf("%-8st", metaData.getColumnName(i));
             }
             System.out.println();

             do {
                 for (int i = 1; i <= numberOfColumns; i++) {
                     System.out.printf("%-8st", rs.getObject(i));
                 }
                 System.out.println();
             } while (rs.next());

             System.out.println();

         } else {
             System.out.println("No database records foundn");
         }

         
         dbUtilities.DisconnectFromDB();
     } catch (SQLException ex) {
         System.out.println("The following error has occured: " + ex.getMessage());
     }
 }
}
*/
