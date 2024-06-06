import java.util.Scanner;
class Crianca extends Visitante {
	private String nomeResponsavel;
	private String telefoneResponsavel;
	private String codigoIngresso;

	private String nome;

	public Crianca(String nome, int anoNascimento, String nomeResponsavel, String telefoneResponsavel) {
		super(nome, anoNascimento, telefoneResponsavel);
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


	public void imprimirInformacoes() {
		System.out.println("Nome da criança" + nome);
		System.out.println("Nome do responsável: " + nomeResponsavel);
		System.out.println("Código do ingresso: " + codigoIngresso);
		System.out.println("Telefone do responsável: " + telefoneResponsavel);
	}

	public int getAnoNascimento() {
        return 0;
    }

	public String getNome() {
		return nomeResponsavel;
	}

}