import java.util.Scanner;
public class Crianca extends Visitante {

	private String nome;
	private String nomeResponsavel;

	private String codigoIngresso;

	private String telefoneResponsavel;


	public void definirInformacoesEspecificas() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o nome da criança: ");
		this.nome = scanner.nextLine();
		System.out.println("Digite o nome do responsável: ");
		this.nomeResponsavel = scanner.nextLine();
		System.out.println("Digite o código do ingresso: ");
		this.codigoIngresso = scanner.nextLine();
		System.out.println("Digite o telefone do responsável: ");
		this.telefoneResponsavel = scanner.nextLine();
	}

	@Override
	public void imprimirInformacoes() {
		System.out.println("Nome da criança" + nome);
		System.out.println("Nome do responsável: " + nomeResponsavel);
		System.out.println("Código do ingresso: " + codigoIngresso);
		System.out.println("Telefone do responsável: " + telefoneResponsavel);
	}


	public double CalculaPreco() {
		return 0;
	}

}
