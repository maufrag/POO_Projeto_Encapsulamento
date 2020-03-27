package Classes.Partida;

import java.util.Random;
import java.util.Date;
import Classes.Time.Time;

public class Partida
{
    private Time timeVisitante;
    private Time timeLocal;
    private int scoreVisitante;
    private int scoreLocal;
    private Date dataPartida;
    
    public Partida(final Time timeLocal, final Time timeVisitante) {
        this.timeLocal = timeLocal;
        this.timeVisitante = timeVisitante;
        this.dataPartida = new Date();
    }
    
    public Time getTimeVisitante() {
        return this.timeVisitante;
    }
    
    public void setTimeVisitante(final Time timeVisitante) {
        this.timeVisitante = timeVisitante;
    }
    
    public Time getTimeLocal() {
        return this.timeLocal;
    }
    
    public void setTimeLocal(final Time timeLocal) {
        this.timeLocal = timeLocal;
    }
    
    public int getScoreVisitante() {
        return this.scoreVisitante;
    }
    
    public void setScoreVisitante(final int scoreVisitante) {
        this.scoreVisitante = scoreVisitante;
    }
    
    public int getScoreLocal() {
        return this.scoreLocal;
    }
    
    public void setScoreLocal(final int scoreLocal) {
        this.scoreLocal = scoreLocal;
    }
    
    public Date getDataPartida() {
        return this.dataPartida;
    }
    
    public void setDataPartida(final Date dataPartida) {
        this.dataPartida = dataPartida;
    }
    
    public void iniciarPartida() {
        System.out.println("*** Pronto para iniciar partida? <Pressiona a tecla enter>");
        lerTeclaEnter();
        System.out.println("Inicio de Jogo. Partida Iniciada !!");
    }
    
    public void mostrarResultado() {
        final Random random = new Random();
        this.scoreLocal = random.nextInt(11);
        this.scoreVisitante = random.nextInt(11);
        System.out.println("\n");
        System.out.println(String.valueOf(this.timeLocal.getNome()) + " " + this.scoreLocal + " X " + this.scoreVisitante + " " + this.timeVisitante.getNome());
        System.out.println("\n");
        if (this.scoreLocal == this.scoreVisitante) {
            this.timeLocal.setPontos(1);
            this.timeVisitante.setPontos(1);
            this.timeLocal.setQtdEmpates(1);
            this.timeVisitante.setQtdEmpates(1);
        }
        else if (this.scoreLocal > this.scoreVisitante) {
            this.timeLocal.setPontos(3);
            this.timeLocal.setQtdVitorias(1);
            this.timeVisitante.setQtdDerrotas(1);
        }
        else {
            this.timeVisitante.setPontos(3);
            this.timeLocal.setQtdDerrotas(1);
            this.timeVisitante.setQtdVitorias(1);
        }
        this.timeLocal.listar();
        System.out.println("\n");
        this.timeVisitante.listar();
    }
    
    public void finalizarPartida(final int numeroPartidaAtual, final int qtdPartidasTotais) {
        final int qtdPartidasRestante = qtdPartidasTotais - numeroPartidaAtual;
        System.out.println("********************************************************************");
        System.out.println((qtdPartidasRestante == 0) ? "Todas as partidas já foram realizadas.\nTecle Enter para continuar" : ("Tecle Enter para iniciar a próxima partida ( " + numeroPartidaAtual + " de " + qtdPartidasTotais + " restante )."));
        lerTeclaEnter();
    }
    
    private static void lerTeclaEnter() {
        try {
            System.in.read(new byte[2]);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
