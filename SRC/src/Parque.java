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
	}

	public void Registra_visitante() {
	//TODO adicionar diferenciação para adulto e criança, adicionando os parametros adicionais
	}
	public void Registra_atracoes() {

	}

	//TODO Criar método de pesquisa por sequencial
	public Visitante pesquisaVisitanteIngresso(int seq){
		return null;
	}

	//TODO Criar método de pesquisa por sequencial
	public Visitante pesquisaVisitanteNome(String nome){
		return null;
	}

	public void emitirIngresso (Visitante v) {
		if (!v.isTemIngresso() && ingressosPorDia > 0) {
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
