public class Adulto extends Visitante {

	private int telefone;

	public Adulto(String nome, int anoNascimento, String telefone) {
		super(nome, anoNascimento, telefone);
	}

	public double CalculaPreco() {
		return 0;
	}

}
