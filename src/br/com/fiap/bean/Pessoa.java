package br.com.fiap.bean;

public class Pessoa {
	
	private int id;
	private int codigo;
	private String nome;
	private String sobrenome;
	private String email;
	private double peso;
	private double altura;
	private String atividade;
	private int maxPressao;
	private int minPressao;
	private String alimentacao;
	private double valor_pressao;
	
	public Pessoa() {
		super();
	}
	
	public Pessoa (String nome, String sobrenome, String email, double peso,
			       double altura, String atividade, int maxPressao, int minPressao,
			       String alimentacao) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.peso = peso;
		this.altura = altura;
		this.atividade = atividade;
		this.maxPressao = maxPressao;
		this.minPressao = minPressao;
		this.alimentacao = alimentacao;
		
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public int getMaxPressao() {
		return maxPressao;
	}

	public void setMaxPressao(int maxPressao) {
		this.maxPressao = maxPressao;
	}

	public int getMinPressao() {
		return minPressao;
	}

	public void setMinPressao(int minPressao) {
		this.minPressao = minPressao;
	}

	public String getAlimentacao() {
		return alimentacao;
	}

	public void setAlimentacao(String alimentacao) {
		this.alimentacao = alimentacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getValor_pressao() {
		return valor_pressao;
	}

	public void setValor_pressao(double valor_pressao) {
		this.valor_pressao = valor_pressao;
	}
	
	

}
