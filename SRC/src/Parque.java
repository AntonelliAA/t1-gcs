import java.util.ArrayList;

public class Parque {

	private ArrayList <Visitante> visitantes;
	private ArrayList <Atracao> atracoes;
	private int ingressosPorDia = 500;

	public void Registra_visitante() {
	//TODO adicionar diferenciação para adulto e criança, adicionando os parametros adicionais
	}
	public void Registra_atracoes() {

	}

	public void emitirIngresso (Visitante v) {
		if (v.isTemIngresso() == false && ingressosPorDia > 0) {
			v.setTemIngresso(true);
			ingressosPorDia = ingressosPorDia - 1;
		} else {
			System.out.println("ERRO! Não foi possivel emitir o ingresso.");
		}
	}


}
