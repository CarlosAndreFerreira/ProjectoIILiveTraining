package Projecto_2;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ListarTudo {
	
	public ListarTudo() {
		System.out.println("Selecionou a opção 2.");
		
		DisplayResults();
	}
	
	private void DisplayResults() {
		DbUtilities dbUtilities = new DbUtilities();
		String stmt;
		ResultSet rs;
		int nrColumns;
		
		try {
			stmt = "SELECT cliente_id, tipo_de_cliente, nome, cc, morada, telefones, email, profissão, contas, cartões, contas_id From dbbanco.Cliente";
			rs = dbUtilities.ReadRecords(stmt);
			
			if (rs.next()) {
				do {
					System.out.println(rs.getInt(1)+" " + ""+ rs.getString(2)+""+" "+ rs.getString(3)+" "+" " +" "+ rs.getString(4) +" "+"" + rs.getString(5) +" "+ rs.getInt(6) + " "+ rs.getString(7) +" "+ rs.getString(8)+ " "+ rs.getInt(9)+ " "+ rs.getInt(10)+ rs.getInt(11));
				}while (rs.next());
			}else
				System.out.println("Não há registos.");
		
			}catch (SQLException e) {
				System.out.println("Ocorreu o erro: " + e.getMessage());
		}finally {
			dbUtilities.DisconnectFromDB();
			System.out.println();
			Main.display();
		}
	}
}
