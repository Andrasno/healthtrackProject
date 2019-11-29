package br.com.fiap.bean;

public class Peso extends Pessoa{
	private int cod_peso;
	private double valor_peso;
	
	
	public int getCod_peso() {
		return cod_peso;
	}

	public void setCod_peso(int cod_peso) {
		this.cod_peso = cod_peso;
	}

	public double getValor_peso() {
		return valor_peso;
	}

	public void setValor_peso(double valor_peso) {
		this.valor_peso = valor_peso;
	}

	public Peso () {
		super();
		
	}
}
