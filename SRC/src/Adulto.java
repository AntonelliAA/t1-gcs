import java.util.Scanner;

public class Adulto extends Visitante {

	private String nome;
	private String codigoIngresso;
	private String telefone;

	public Adulto(String nome, int anoNascimento, String telefone) {
		super(nome, anoNascimento, telefone);
	}

	public double CalculaPreco() {
		return 0;
	}

	public void definirInformacoesEspecificas() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o nome: ");
		this.nome = scanner.nextLine();
		System.out.println("Digite o telefone: ");
		this.telefone = scanner.nextLine();
		System.out.println("Digite o código do ingresso: ");
		this.codigoIngresso = scanner.nextLine();
	}

	@Override
	public void imprimirInformacoes() {
		System.out.println("Nome: " + nome);
		System.out.println("Código do ingresso: " + codigoIngresso);
		System.out.println("Telefone: " + telefone);
	}

}
