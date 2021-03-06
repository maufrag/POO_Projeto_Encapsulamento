package Classes.Time;

public class Time {
	private String nome;
	private int qtdVitorias;
	private int qtdEmpates;
	private int qtdDerrotas;
	private int pontos;

	public Time() {
		this.qtdVitorias = 0;
		this.qtdEmpates = 0;
		this.qtdDerrotas = 0;
		this.pontos = 0;
	}

	public int getPontos() {
		return this.pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQtdVitorias() {
		return this.qtdVitorias;
	}

	public void setQtdVitorias(int qtdVitorias) {
		this.qtdVitorias = qtdVitorias;
	}

	public int getQtdEmpates() {
		return this.qtdEmpates;
	}

	public void setQtdEmpates(int qtdEmpates) {
		this.qtdEmpates = qtdEmpates;
	}

	public int getQtdDerrotas() {
		return this.qtdDerrotas;
	}

	public void setQtdDerrotas(int qtdDerrotas) {
		this.qtdDerrotas = qtdDerrotas;
	}

	public void listar() {
		System.out.println("Time: " + this.nome);
		System.out.println("Vitorias: " + this.qtdVitorias);
		System.out.println("Empates: " + this.qtdEmpates);
		System.out.println("Derrotas: " + this.qtdDerrotas);
		System.out.println("Pontos " + this.pontos);
	}
}
