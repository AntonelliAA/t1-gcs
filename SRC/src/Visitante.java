
import java.util.ArrayList;

public abstract class Visitante {
	public Visitante(String nome, int anoNascimento) {
		this.nome = nome;
		this.anoNascimento = anoNascimento;
    }

	private String nome;

	private int anoNascimento;

	private Ingresso ingresso;

	private String telefone;

	private ArrayList<Atracao> atracoesVisitadas = new ArrayList<>();

	private boolean temIngresso = false;


	public void visitar(Atracao a){
		atracoesVisitadas.add(a); //adicionar a atracao na lista de visitadas
	}

	
	public int GetIdade() {
		return 2024 ;
    /**
	 * calcula a idade baseado no ano de nascimento
	 */
	}

	public void setTemIngresso(boolean temIngresso) {
		this.temIngresso = temIngresso;
	}


	private String getTelefone() {
		return telefone;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public String getNome() {
		return nome;
	}


	public abstract void imprimirInformacoes();

	public boolean isTemIngresso() {
        return false;
    }

	public ArrayList<Atracao> getAtracoesVisitadas() {
		return atracoesVisitadas;
	}


}
