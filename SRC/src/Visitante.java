
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
	public void visitar(Atracao a){
		atracoes_visitadas.add(a); //adicionar a atracao na lista de visitadas
	}

	
	public int GetIdade() {
		return 2024 - Ano_nascimento;
    /**
	 * calcula a idade baseado no ano de nascimento
	 */
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

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public Object getNome() {
		return nome;
	}

	public abstract void definirInformacoesEspecificas();
	public abstract void imprimirInformacoes();

	public boolean isTemIngresso() {
        return false;
    }
}
