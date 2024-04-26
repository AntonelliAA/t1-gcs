import java.util.ArrayList;

public abstract class Visitante {

	private int Nome;

	private int Ano_nascimento;

	private ArrayList<Atracao> atracoes_visitadas;

	public void visitante(int Nome, int ano) {

	}

	/**
	 * calcula a idade baseado no ano de nascimento
	 */
	public void visitar(Atracao a){
		atracoes_visitadas.add(a); //adicionar a atracao na lista de visitadas
	}
	public int GetIdade() {
		return 2024 - Ano_nascimento; //calculo temporario de idade }
	}

	public abstract double CalculaPreco();

}
