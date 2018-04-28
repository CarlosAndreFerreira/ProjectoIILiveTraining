package Projecto_2;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Scanner;

public class ContaPoupanca extends Conta {

	String referenciaInterna = "CPP." + Conta.numeroDeConta;
	LocalDate aposUmAno = this.getdataCriacao().plusDays(365);

	protected ContaOrdem contaordem;
	protected Conta contaDestino;
	protected Cliente cliente;
	protected double saldoInicial;

	static ArrayList<Movimentos> depositosContaPoupanca = new ArrayList<Movimentos>();

	ContaPoupanca(Cliente cliente, double saldoInicial) {
		super(cliente, saldoInicial);
		this.saldoInicial = saldoInicial;
		displayMenu();
	}
	
	private void displayMenu() {
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
				
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			case "4":
				
				break;
			case "5":
				
				break;
			case "6":
			
				break;
			case "7":
				Main.display();
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
	
	

	@Override
	void levantamento(double valor) {
		System.out.println("Movimento inválido para conta poupança");
	}

	@Override
	void deposito(double valor) {
		if (valor > 0) {
			this.saldo += valor;
			System.out.println("Depósito efectuado. Saldo = " + this.saldo + " €.");
			movimento = new Movimentos(valor, "Depósito", "Conta Poupança", LocalDate.now());
			arrayMovimentos.add(movimento);
			depositosContaPoupanca.add(movimento);
			numeroMovimento++;
		} else {
			System.out.println("Operação não efectuada. Valor inválido.");
		}
	}

	public void avançarPeriodoAnual() {

		double currSaldo = this.getSaldo();
		double juro = 0;		
		
		
		// Se o saldo não se alterar ao longo do ano
		if (depositosContaPoupanca.isEmpty()) {
			System.out.println("Periodo anual avançado. Saldo atual:");
			currSaldo += (currSaldo * 0.05);
			System.out.println("1 - Periodo anual avançado. Saldo atual: "+this.getSaldo()+"€");
		} else {
			
			for (int i = 0; i < depositosContaPoupanca.size(); i++) {				
				
				if (i == 0) {
				Period thePeriod = Period.between(this.getdataCriacao(), 
						depositosContaPoupanca.get(i).data);
				juro += currSaldo * 0.05 * (thePeriod.getDays() / 365);
				currSaldo += depositosContaPoupanca.get(i).montante;
				System.out.println("2 - Periodo anual avançado. Saldo atual: "+this.getSaldo()+"€");
				}else if (i == depositosContaPoupanca.size() - 1) {
					Period lastPeriod = Period.between(depositosContaPoupanca.get(i).data, dataAposAno);
					juro += currSaldo * 0.05 * (lastPeriod.getDays() / 365);
					this.setSaldo(currSaldo + juro);
					System.out.println("3 - Periodo anual avançado. Saldo atual: "+this.getSaldo()+"€");
					break;
				} else {
					Period midPeriod = Period.between(depositosContaPoupanca.get(i-1).data, 
							depositosContaPoupanca.get(i).data);
					juro += currSaldo * 0.05 * (midPeriod.getDays() / 365);
					currSaldo += depositosContaPoupanca.get(i).montante;
					System.out.println("4 -Periodo anual avançado. Saldo atual: "+this.getSaldo()+"€");
				}
				}
			}
		}	

}