package Projecto_2;

import java.time.LocalDate;

class Movimentos {
	
	protected LocalDate data;
	protected String referenciaPlataforma;
	protected String referenciaMovimento;
	protected double montante;
	protected int numeroMovimento;
	
	Movimentos(double montante, String referenciaMovimento, String referenciaPlataforma, LocalDate data) {
		this.montante = montante;
		this.referenciaMovimento = referenciaMovimento;
		this.referenciaPlataforma = referenciaPlataforma;
		this.data = data;
		this.numeroMovimento = Conta.numeroMovimento;
	}
	
	void mostraMovimentos() {
		System.out.println();
		System.out.println("Movimento nï¿½mero: " + this.numeroMovimento);
		System.out.println("Montante: " + montante + "€;");
		System.out.println("Tipo de movimento efectuado: " + referenciaMovimento + ";");
		System.out.println("Movimento efectuado na plataforma: " + referenciaPlataforma + ";");
		System.out.println("Data do movimento: " + data + ";");
	}
	

}
