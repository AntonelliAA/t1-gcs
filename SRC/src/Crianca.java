import java.util.Scanner;
class Crianca extends Visitante {
	private String nomeResponsavel;
	private String telefoneResponsavel;
	private String codigoIngresso;

	private String nome;

	public Crianca(String nome, int anoNascimento, String nomeResponsavel, String telefoneResponsavel) {
		super(nome, anoNascimento);
		this.nomeResponsavel = nomeResponsavel;
		this.telefoneResponsavel = telefoneResponsavel;

	}

	public String getCodigoIngresso() {
		return codigoIngresso;
	}

	public void setCodigoIngresso(String codigoIngresso) {
		this.codigoIngresso = codigoIngresso;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public String getTelefoneResponsavel() {
		return telefoneResponsavel;
	}

	@Override
	public String toString() {
		return "Criança{" +
				"nome='" + getNome() + '\'' +
				", anoNascimento=" + getAnoNascimento() +
				", nomeResponsavel='" + nomeResponsavel + '\'' +
				", telefoneResponsavel='" + telefoneResponsavel + '\'' +
				'}';
	}


	public void imprimirInformacoes() {
		System.out.println("Nome da criança: " + getNome());
		System.out.println("Ano de Nascimento: " + getAnoNascimento());
		System.out.println("Nome do responsável: " + getNomeResponsavel());
		System.out.println("Código do ingresso: " + "codigoIngresso");
		System.out.println("Telefone do responsável: " + getTelefoneResponsavel());
	}



}