import java.util.ArrayList;
import java.util.Scanner;

public class Parque {

	private ArrayList <Visitante> visitantes;
	private ArrayList <Atracao> atracoes;

	/*public void Registra_visitante() {
	//TODO adicionar diferenciação para adulto e criança, adicionando os parametros adicionais
	}*/
	public void Registra_atracoes() {

	}

	public void cadastrarVisitante() {
		if (visitantes == null) {
			visitantes = new ArrayList<>();
		}

		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o tipo de visitante (1 para Adulto, 2 para Criança): ");
		int tipo = scanner.nextInt();
		scanner.nextLine();

		Visitante novoVisitante = null;
		switch (tipo) {
			case 1: // Adulto
				novoVisitante = new Adulto();
				break;
			case 2: // Criança
				novoVisitante = new Crianca();
				break;
			default:
				System.out.println("Tipo de visitante inválido.");
				return;
		}

		// Chamando o método para definir informações específicas do visitante
		novoVisitante.definirInformacoesEspecificas();

		// Adicionando o novo visitante à lista
		visitantes.add(novoVisitante);
	}



	public void listarVisitantes() {
		if (visitantes == null || visitantes.isEmpty()) {
			System.out.println("Nenhum visitante cadastrado.");
		} else {
			System.out.println("Visitantes cadastrados:");
			for (Visitante visitante : visitantes) {
				System.out.println("==========================================");
				visitante.imprimirInformacoes();
			}
		}
	}

}
