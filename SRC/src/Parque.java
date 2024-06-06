import java.util.ArrayList;

public class Parque {

	private ArrayList <Visitante> visitantes;
	private ArrayList <Atracao> atracoes;
	private boolean isClosed;
	private int lastSeqIngresso;
	private int ingressosPorDia;

	public Parque(int ingressosPorDia){
		this.ingressosPorDia = ingressosPorDia;
		lastSeqIngresso = 0;
		visitantes = new ArrayList<>();
		atracoes = new ArrayList<>();
		isClosed = false;
		atracoesPadrao();
	}

	public void Registra_visitante() {
	//TODO adicionar diferenciação para adulto e criança, adicionando os parametros adicionais
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

	//TODO Criar método de fechamento de parque
	public void fechaDia(){

	}

	//TODO Criar método para abrir o parque
	public void abreDia(){

	}
}
