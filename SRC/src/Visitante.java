import lombok.Data;

import java.util.ArrayList;

@Data
public abstract class Visitante {

	private String nome;

	private int ano_nascimento;

	private Ingresso ingresso;

	private ArrayList<Atracao> atracoes_visitadas;

	private boolean temIngresso = false;

	public void visitante(int Nome, int ano) {

	}

	/**
	 * calcula a idade baseado no ano de nascimento
	 */
	public int GetIdade() {
		return 2024 - ano_nascimento; //calculo temporario de idade }
	}

	public abstract double CalculaPreco();


	public boolean isTemIngresso() {
		return temIngresso;
	}

	public void setTemIngresso(boolean temIngresso) {
		this.temIngresso = temIngresso;
	}
}
