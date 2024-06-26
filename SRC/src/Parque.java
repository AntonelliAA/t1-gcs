import java.util.*;
import java.time.LocalDate;
import java.time.YearMonth;

public class Parque {

	private ArrayList <Visitante> visitantes;
	ArrayList <Atracao> atracoes;
	private ArrayList<Ingresso> ingressos;
	private ArrayList <Dia> dias;
	private boolean isClosed;
	private int lastSeqIngresso;
	private int ingressosPorDia;

	public void reset_diario(){
		atracoes.sort(Comparator.comparing(Atracao::getVisitas));//deixa as atracoes em ordem de mais visistadas, para facilitar depois
		for (Atracao a : atracoes){ //novo dia começa com todas atracoes sem visitas
			a.setVisitas(0);
		}
		visitantes.clear(); // remove todos visitantes do dia anteiror
	}
	public Atracao pesquisaAtracao(String nome) {
		for (Atracao atracao : atracoes) {
			if (atracao.getNome().equalsIgnoreCase(nome)) {
				return atracao;
			}
		}
		return null;
	}


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
		ingressos = new ArrayList<>();
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
			String idIngresso = LocalDate.now().toString() + " seq " + (lastSeqIngresso + 1);
			Ingresso ingresso = new Ingresso(idIngresso, v);
			v.setTemIngresso(true);
			ingressos.add(ingresso);
			ingressosPorDia = ingressosPorDia - 1;
		} else {
			System.out.println("ERRO! Não foi possivel emitir o ingresso.");
		}
	}


	public double calcularFaturamento(int mes, int ano) {
		double faturamento = 0;
		YearMonth yearMonth = YearMonth.of(ano, mes);
		for (Ingresso ingresso : ingressos) {
			LocalDate dataIngresso = ingresso.getData();
			if (YearMonth.from(dataIngresso).equals(yearMonth)) {
				faturamento += ingresso.getPreco();
			}
		}
		return faturamento;
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
		String nome;
		String nomeResponsavel;
		String telefone = "0";
		String telefoneResponsavel = "0";
		int anoNascimento;

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
				System.out.println("Digite o nome: ");
				nome = scanner.nextLine();
				System.out.println("Digite o telefone: ");
				telefone = scanner.nextLine();
				System.out.println("Digite o ano de nascimento: ");
				anoNascimento = scanner.nextInt();
				scanner.nextLine();
				novoVisitante = new Adulto(nome, anoNascimento, telefone);
				break;
			case 2: // Criança
				System.out.println("Digite o nome da criança: ");
				nome = scanner.nextLine();
				System.out.println("Digite o nome do responsável: ");
				nomeResponsavel = scanner.nextLine();
				System.out.println("Digite o ano de nascimento: ");
				anoNascimento = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Digite o telefone do responsável: ");
				telefoneResponsavel = scanner.nextLine();
				novoVisitante = new Crianca(nome, anoNascimento, nomeResponsavel, telefoneResponsavel);
				break;
			default:
				System.out.println("Tipo de visitante inválido.");
				return;
		}

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

	// Método para consultar visitas por data
	public void consultarVisitasPorData(String data) {
		LocalDate dataConsulta = LocalDate.parse(data);
		int[] visitasPorAtracao = new int[atracoes.size()];

		// Conta as visitas para cada atração na data especificada
		for (Ingresso ingresso : ingressos) {
			if (ingresso.getData().equals(dataConsulta)) {
				Visitante visitante = ingresso.getVisitante();
				for (Atracao atracao : visitante.getAtracoesVisitadas()) {
					for (int i = 0; i < atracoes.size(); i++) {
						if (atracoes.get(i).getNome().equalsIgnoreCase(atracao.getNome())) {
							visitasPorAtracao[i]++;
						}
					}
				}
			}
		}

		// Cria uma lista de pares (nome da atração, número de visitas) para ordenar
		List<AtracaoVisitas> listaVisitas = new ArrayList<>();
		for (int i = 0; i < atracoes.size(); i++) {
			listaVisitas.add(new AtracaoVisitas(atracoes.get(i).getNome(), visitasPorAtracao[i]));
		}

		// Ordena a lista pela quantidade de visitas
		Collections.sort(listaVisitas, new Comparator<AtracaoVisitas>() {
			@Override
			public int compare(AtracaoVisitas av1, AtracaoVisitas av2) {
				return Integer.compare(av2.getVisitas(), av1.getVisitas());
			}
		});

		// Exibe as visitas por atração
		System.out.println("Visitas por atração na data " + data + ":");
		for (AtracaoVisitas av : listaVisitas) {
			System.out.println(av.getNomeAtracao() + ": " + av.getVisitas() + " visitas");
		}
	}

	// Classe auxiliar para armazenar o nome da atração e o número de visitas
	private class AtracaoVisitas {
		private String nomeAtracao;
		private int visitas;

		public AtracaoVisitas(String nome, int visitas) {
			this.nomeAtracao = nome;
			this.visitas = visitas;
		}

		public String getNomeAtracao() {
			return nomeAtracao;
		}

		public int getVisitas() {
			return visitas;
		}
	}





}
