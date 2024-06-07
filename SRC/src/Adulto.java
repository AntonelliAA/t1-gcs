import java.util.Scanner;

public class Adulto extends Visitante {


	private String codigoIngresso;
	private String telefone;


	public Adulto(String nome, int anoNascimento, String telefone) {
		super(nome, anoNascimento);
		this.telefone = telefone;
	}

	public double CalculaPreco() {
		return 0;
	}


	@Override
	public void imprimirInformacoes() {
		System.out.println("Nome: " + getNome());
		System.out.println("Código do ingresso: " + "getCodigo");
		System.out.println("Telefone: " + getTelefone());
	}

	private String getTelefone() {
		return telefone;
	}

	@Override
	public String toString() {
		return "Visitante{" +
				"nome='" + getNome() + '\'' +
				", anoNascimento=" + getAnoNascimento() +
				", telefone='" + getTelefone() + '\'' +
				'}';
	}

}
