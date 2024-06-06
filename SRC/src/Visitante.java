
import java.util.ArrayList;

public abstract class Visitante {

	private String nome;

	private int anoNascimento;

	private Ingresso ingresso;

	private String telefone;

	private ArrayList<Atracao> atracoes_visitadas;

	private boolean temIngresso = false;

	public Visitante(String nome, int anoNascimento, String telefone) {
		this.nome = nome;
		this.anoNascimento = anoNascimento;
		this.telefone = telefone;
	}

	public boolean isTemIngresso() {
		return temIngresso;
	}

	public void setTemIngresso(boolean temIngresso) {
		this.temIngresso = temIngresso;
	}

	@Override
	public String toString() {
		return "Visitante{" +
				"nome='" + nome + '\'' +
				", anoNascimento=" + anoNascimento +
				", telefone='" + telefone + '\'' +
				'}';
	}
}
