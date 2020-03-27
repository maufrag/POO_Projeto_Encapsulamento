import java.util.Date;
import Classes.Partida.Partida;
import Classes.Time.Time;
import java.util.Scanner;

public class ArquivoMain {
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe o n\u00famero de partidas: ");
		int qtdPartidasInformada = -1;
		qtdPartidasInformada = obterQtdPartidasInformada(qtdPartidasInformada);
		if (qtdPartidasInformada > 0) {
			int numeroPartidaAtual = 1;
			do {
				Time timeLocal = new Time();
				Time timeVisitante = new Time();
				
				System.out.println("Iniciando as partidas da Rodada do Brasileir\u00e3o.");
				System.out.println(
						"Vai começar a partida número " + numeroPartidaAtual + " de " + qtdPartidasInformada);
				
				System.out.println("Informe o nome do time local: ");
				timeLocal.setNome(scan.nextLine());
				
				System.out.println("\nInforme o nome do time visitante: ");
				timeVisitante.setNome(scan.nextLine());
				validarNomeDosTimes(timeLocal, timeVisitante);
				System.out.println("\nPreparando jogo número " + numeroPartidaAtual);
				timeLocal.listar();
				
				System.out.println();
				timeVisitante.listar();
				
				Partida partida = new Partida(timeLocal, timeVisitante);
				Date dataAtual = new Date();
				
				partida.setDataPartida(dataAtual);
				partida.iniciarPartida();
				partida.mostrarResultado();
				partida.finalizarPartida(numeroPartidaAtual, qtdPartidasInformada);
				++numeroPartidaAtual;
			} while (qtdPartidasInformada >= numeroPartidaAtual);
			listarFinalizacaoTrabalho();
		} else {
			System.out.println("Valor informado foi menor que 1.");
		}
	}

	private static void listarFinalizacaoTrabalho() {
		Date date = new Date();
		printarAsterisco();
		printarAsterisco();
		System.out.println("******FIM DE RODADA******");
		System.out.println("Integrates do grupo: \nMateus Torres Ferreira");
		System.out.println("Date e hora da finalização das partidas " + date);
		printarAsterisco();
		System.out.println("Github: https://github.com/maufrag/POO_Projeto_Encapsulamento");
		printarAsterisco();
	}

	private static void printarAsterisco() {
		System.out.println("*************************");
	}

	private static boolean isNullOrWhiteSpace(final String texto) {
		if (texto == null) {
			return true;
		}
		if (texto.isEmpty()) {
			return true;
		}
		for (int i = 0; i < texto.length(); ++i) {
			if (texto.charAt(i) != ' ') {
				return false;
			}
		}
		return true;
	}

	private static void validarNomeDosTimes(final Time timeLocal, final Time timeVisitante) {
		if (isNullOrWhiteSpace(timeLocal.getNome()) || isNullOrWhiteSpace(timeVisitante.getNome())) {
			System.out.println("Pelo menos um dos nomes dos times está inválido, por favor reinsira o nome do time");
			reinsirerNomeDosTimes(timeLocal, timeVisitante);
		}
	}

	private static void reinsirerNomeDosTimes(final Time timeLocal, final Time timeVisitante) {
		Scanner scan = new Scanner(System.in);
		if (isNullOrWhiteSpace(timeLocal.getNome()) && isNullOrWhiteSpace(timeVisitante.getNome())) {
			System.out.println("Informe o nome do time local corretamente: ");
			timeLocal.setNome(scan.nextLine());
			System.out.println("\nInforme o nome do time visitante corretamente: ");
			timeVisitante.setNome(scan.nextLine());
		} else if (isNullOrWhiteSpace(timeLocal.getNome())) {
			System.out.println("Informe o nome do time local corretamente: ");
			timeLocal.setNome(scan.nextLine());
		} else {
			System.out.println("\nInforme o nome do time visitante corretamente: ");
			timeVisitante.setNome(scan.nextLine());
		}
		validarNomeDosTimes(timeLocal, timeVisitante);
	}

	private static boolean isInteger(final String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			Integer.parseInt(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	private static int obterQtdPartidasInformada(int valor) {
		final Scanner scan = new Scanner(System.in);
		boolean valido;
		do {
			final String valorAuxiliar = scan.nextLine();
			valido = isInteger(valorAuxiliar);
			if (!valido) {
				System.out.println("Informe o n\u00famero de partidas corretamente: ");
			} else {
				valor = Integer.parseInt(valorAuxiliar);
			}
		} while (!valido);
		return valor;
	}
}
