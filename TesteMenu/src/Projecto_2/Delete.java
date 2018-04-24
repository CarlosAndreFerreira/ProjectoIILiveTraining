package Projecto_2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
	public Delete() {
		
		Scanner userInput = new Scanner (System.in);
		int cliente_id;
		String confirm_delete, stmt;
		
		System.out.println("Selecionou a opção 4");
		System.out.println("Introduzir o identificador do cliente a eliminar:");
		cliente_id = userInput.nextInt();
		
		DisplayRecord(cliente_id);
		
		System.out.println("Inserir \"s\" ou \"S\" para confirmar a eliminação.");
		confirm_delete = userInput.next();
		
		if ("S".equalsIgnoreCase(confirm_delete)) {
			DbUtilities dbutilities = new DbUtilities();
			stmt = "DELETE FROM dbbanco.Cliente WHERE cliente_id = " + cliente_id;
			
			dbutilities.ExecuteSqlStatement(stmt);
			
			System.out.println("O registo foi eliminado com sucesso");
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
					System.out.println(rs.getInt(1)+" " + ""+ rs.getString(2)+""+" "+ rs.getString(3)+" "+" " +" "+ rs.getString(4) +" "+"" + rs.getString(5) +" "+ rs.getInt(6) + " "+ rs.getString(7) +" "+ rs.getString(8)+ " "+ rs.getInt(9)+ " "+ rs.getInt(10)+ rs.getInt(11)  );
				}while (rs.next());
			}else
				System.out.println("Não há registos.");
		} catch (SQLException e) {
			System.out.println("Ocorreu o erro: " + e.getMessage());
		}
	}
}

