import java.util.Date;
import Classes.Partida.Partida;
import Classes.Time.Time;
import java.util.Scanner;

public class ArquivoMain {
	public static void main(String[] args) {

		System.out.println("Informe o número de partidas: ");

		int qtdPartidasInformada = -1;
		qtdPartidasInformada = obterQtdPartidasInformada(qtdPartidasInformada);

		if (qtdPartidasInformada > 0) {

			int numeroPartidaAtual = 1;

			Scanner scan = new Scanner(System.in);
			do {
				Time timeLocal = new Time();
				Time timeVisitante = new Time();

				System.out.println("Iniciando as partidas da Rodada do Brasileirão.");
				System.out
						.println("Vai começar a partida número " + numeroPartidaAtual + " de " + qtdPartidasInformada);

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

				System.out.println("*** Pronto para iniciar partida? <Pressiona a tecla enter>");
				lerTeclaEnter();
				System.out.println("Inicio de Jogo. Partida Iniciada !!");
				partida.setDataPartida(dataAtual);
				partida.iniciarPartida();
				partida.mostrarResultado();
				partida.finalizarPartida();
				
				timeLocal.listar();
				System.out.println("\n");
				timeVisitante.listar();

				exibirMensagemFinalDaPartida(qtdPartidasInformada, numeroPartidaAtual);
				lerTeclaEnter();
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

	private static boolean isNullOrWhiteSpace(String texto) {
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

	private static void validarNomeDosTimes(Time timeLocal, Time timeVisitante) {
		if (isNullOrWhiteSpace(timeLocal.getNome()) || isNullOrWhiteSpace(timeVisitante.getNome())) {
			System.out.println("Pelo menos um dos nomes dos times está inválido, por favor reinsira o nome do time");
			reinsirerNomeDosTimes(timeLocal, timeVisitante);
		}
	}

	private static void reinsirerNomeDosTimes(Time timeLocal, Time timeVisitante) {
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

	private static boolean isInteger(String strNum) {
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
		Scanner scan = new Scanner(System.in);
		boolean valido;
		do {
			String valorAuxiliar = scan.nextLine();
			valido = isInteger(valorAuxiliar);
			if (!valido) {
				System.out.println("Informe o número de partidas corretamente: ");
			} else {
				valor = Integer.parseInt(valorAuxiliar);
			}
		} while (!valido);
		return valor;
	}

	private static void lerTeclaEnter() {
		try {
			System.in.read(new byte[2]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void exibirMensagemFinalDaPartida(int qtdPartidasTotais, int numeroPartidaAtual) {
		int qtdPartidasRestante = qtdPartidasTotais - numeroPartidaAtual;
		System.out.println("********************************************************************");
		System.out.println(
				(qtdPartidasRestante == 0) ? "Todas as partidas já foram realizadas.\nTecle Enter para continuar"
						: ("Tecle Enter para iniciar a próxima partida ( " + qtdPartidasRestante + " de "
								+ qtdPartidasTotais + " restante )."));
	}
}
