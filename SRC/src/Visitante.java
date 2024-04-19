public abstract class Visitante {

	private int Nome;

	private int Ano_nascimento;

	public void visitante(int Nome, int ano) {

	}

	/**
	 * calcula a idade baseado no ano de nascimento
	 */
	public int GetIdade(){return 0;}

	public abstract double CalculaPreco();

}
