package br.com.fiap.bean;

public class Atividade extends Pessoa{
	int cod_atividade;
	String atividade_realizada;
	
	public Atividade() {
		super();
	}
	
	public Atividade(int cod_atividade, String atividade_realizada ) {
		this.cod_atividade = cod_atividade;
		this.atividade_realizada = atividade_realizada;
		
	}

	public int getCod_atividade() {
		return cod_atividade;
	}

	public void setCod_atividade(int cod_atividade) {
		this.cod_atividade = cod_atividade;
	}

	public String getAtividade_realizada() {
		return atividade_realizada;
	}

	public void setAtividade_realizada() {
		
	}

	
}
