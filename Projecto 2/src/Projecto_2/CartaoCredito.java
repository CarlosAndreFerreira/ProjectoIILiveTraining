package Projecto_2;

public class CartaoCredito extends Cartao {
	

	protected double plafondMax = 500;
	protected double plafond = plafondMax;
	
	//Cliente Normal - plafondMax é 500 ---- else, plafondMax pode ser definido por gestor de conta)	
	
	public CartaoCredito(ContaOrdem contaOrdem) {
		super(contaOrdem);		
	}
	
	public int getNumeroCartao() {
		return numeroCartao;
	}
	
	@Override
	public void levantamento(double valor) {
			
		if (this.contaordem.getSaldo() > valor){
			super.levantamento(valor);	
		} else if (plafond + this.contaordem.getSaldo() > valor) {
			this.plafond -= valor - this.contaordem.getSaldo();
			this.contaordem.levantamento(this.contaordem.getSaldo());
			System.out.println("Plafond atual: "+this.getPlafond()+"€");
		} else {
			System.out.println("Levantamento não efetuado: Saldo insuficiente");
		}			
			
	}	
	
	//Período de 1 mês
	
	public void avancarPeriodo () {
		
		double plafondGasto = plafondMax - this.plafond;
		
		if(this.contaordem.getSaldo() > plafondGasto) {
			//caso haja saldo suficiente para pagar o plafond gasto 
			this.contaordem.levantamento(plafondGasto);
			this.plafond = plafondMax;
			System.out.println("Perido avançado");
			
		} else {
			//Plafond max (-) aquilo que falta pagar relativo ao plafond gasto do mês anterior, com 1% de juros
			this.plafond = (plafondMax - (plafondGasto - this.contaordem.getSaldo()))*0.99;
			this.contaordem.setSaldo(0);	
			System.out.println("Perido avançado, plafond foi atualizado: "+this.plafond);			
		}
	}

	public void cashAdvance (double valor) {		
		
	if(valor > this.plafond) {
		System.out.println("Operação não pode ser efetuada, plafond é insuficiente");
	} else {	
		//cashAdvance equivale a um depósito usando o plafond disponível
		deposito(valor);
		this.plafond -= valor;	
		System.out.println("Cash advance utilizado");
	  }
    }
	
	public double getPlafond() {
		return plafond;
	}
    
	//Poderá ser utilizada para definir PlafondMax pelo gestor de conta
	public void setPlafondMax(double valor) {
		this.plafond = valor;
	}
}
