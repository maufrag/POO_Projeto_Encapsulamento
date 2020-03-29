package Classes.Partida;

import java.util.Random;
import java.util.Date;
import Classes.Time.Time;

public class Partida {
	private Time timeVisitante;
	private Time timeLocal;
	private int scoreVisitante;
	private int scoreLocal;
	private Date dataPartida;

	public Partida(Time timeLocal, Time timeVisitante) {
		this.timeLocal = timeLocal;
		this.timeVisitante = timeVisitante;
		this.dataPartida = new Date();
	}

	public Time getTimeVisitante() {
		return this.timeVisitante;
	}

	public void setTimeVisitante(Time timeVisitante) {
		this.timeVisitante = timeVisitante;
	}

	public Time getTimeLocal() {
		return this.timeLocal;
	}

	public void setTimeLocal(Time timeLocal) {
		this.timeLocal = timeLocal;
	}

	public int getScoreVisitante() {
		return this.scoreVisitante;
	}

	public void setScoreVisitante(int scoreVisitante) {
		this.scoreVisitante = scoreVisitante;
	}

	public int getScoreLocal() {
		return this.scoreLocal;
	}

	public void setScoreLocal(int scoreLocal) {
		this.scoreLocal = scoreLocal;
	}

	public Date getDataPartida() {
		return this.dataPartida;
	}

	public void setDataPartida(Date dataPartida) {
		this.dataPartida = dataPartida;
	}

	public void iniciarPartida() {
		Random random = new Random();
		this.scoreLocal = random.nextInt(11);
		this.scoreVisitante = random.nextInt(11);
	}

	public void mostrarResultado() {
		System.out.println("\n");
		System.out.println(String.valueOf(this.timeLocal.getNome()) + " " + this.scoreLocal + " X "
				+ this.scoreVisitante + " " + this.timeVisitante.getNome());
		System.out.println("\n");
	}

	public void finalizarPartida() {
		if (this.scoreLocal == this.scoreVisitante) {
			this.timeLocal.setPontos(1);
			this.timeVisitante.setPontos(1);
			this.timeLocal.setQtdEmpates(1);
			this.timeVisitante.setQtdEmpates(1);
		} else if (this.scoreLocal > this.scoreVisitante) {
			this.timeLocal.setPontos(3);
			this.timeLocal.setQtdVitorias(1);
			this.timeVisitante.setQtdDerrotas(1);
		} else {
			this.timeVisitante.setPontos(3);
			this.timeLocal.setQtdDerrotas(1);
			this.timeVisitante.setQtdVitorias(1);
		}
	}
}
