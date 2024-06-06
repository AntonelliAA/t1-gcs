class Crianca extends Visitante {
	private String nomeResponsavel;
	private String telefoneResponsavel;
	private String codigoIngresso;

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

	public int getAnoNascimento() {
        return 0;
    }

	public String getNome() {
		return nomeResponsavel;
	}

}