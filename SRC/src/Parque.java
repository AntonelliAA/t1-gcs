import java.util.ArrayList;
import java.util.Scanner;

public class Parque {

	private ArrayList <Visitante> visitantes;
	private ArrayList <Atracao> atracoes;
	private ArrayList <Dia> dias;
	private boolean isClosed;
	private int lastSeqIngresso;
	private int ingressosPorDia;
	private class Dia {
		private int mes;
		private int dia;
		private int ingCrianca;
		private int ingAdulto;
		private double valorTotal;

		Dia(int mes, int dia){
			this.mes = mes;
			this.dia = dia;
		}
		private void calculaValorTotal() {
			valorTotal += (ingCrianca * 80.0) + (ingAdulto * 100.0);
		}
	}


	public Parque(int ingressosPorDia){
		this.ingressosPorDia = ingressosPorDia;
		lastSeqIngresso = 0;
		visitantes = new ArrayList<>();
		atracoes = new ArrayList<>();
		dias = new ArrayList<>();
		isClosed = false;
		atracoesPadrao();
	}

	public void adicionarVisitante(Visitante visitante) {
	visitantes.add(visitante);
	}
	public void Registra_atracoes(Atracao a) {
		atracoes.add(a);
	}

	public void atracoesPadrao () {
		Atracao a1 = new Atracao("Roda-Gigante", 15);
		Atracao a2 = new Atracao("Casa do Terror", 40);
		Atracao a3 = new Atracao("Barco Viking", 60);
		Atracao a4 = new Atracao("Carrinho de Bate-Bate", 10);
		Atracao a5 = new Atracao("Trem Fantasma", 20);
		Atracao a6 = new Atracao("Tirolesa", 2);
		atracoes.add(a1);
		atracoes.add(a2);
		atracoes.add(a3);
		atracoes.add(a4);
		atracoes.add(a5);
		atracoes.add(a6);

	}

	//TODO Criar método de pesquisa por sequencial
	public Visitante pesquisaVisitanteIngresso(int seq){
		return visitantes.get(seq - 1);
	}

	//TODO Criar método de pesquisa por sequencial
	public Visitante pesquisaVisitanteNome(String nome){
		for (Visitante v:
				visitantes) {
			if (v.getNome().equals(nome)){
				return v;
			}
		}
		System.out.println();
		return null;
	}

	public void emitirIngresso (Visitante v) {
		if (!v.isTemIngresso() && lastSeqIngresso < ingressosPorDia) {
			v.setTemIngresso(true);
			ingressosPorDia = ingressosPorDia - 1;
		} else {
			System.out.println("ERRO! Não foi possivel emitir o ingresso.");
		}
	}

	//TODO Criar método de fechamento de parque(executar o calculo de valor total no dia e impedir novos ingressos) f6
	public void fechaDia(){

	}

	//TODO Criar método para abrir o parque (executar lógica para permitir registro de ingressos neste dia) f6
	public void abreDia(){
		Dia dia = new Dia(0,0);
		dias.add(dia);
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
