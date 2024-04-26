import java.util.ArrayList;

public class Parque {

	private ArrayList <Visitante> visitantes;
	private ArrayList <Atracao> atracoes;

	/*public void Registra_visitante() {
	//TODO adicionar diferenciação para adulto e criança, adicionando os parametros adicionais
	}*/
	public void Registra_atracoes() {

	}
	public void registraVisitante(){
		
	}

	public void cadastrarVisitante(Visitante visitante, int tipo, int telefone, int nomeResponsavel, String codigoIngresso, int telefoneResponsavel) {
		if (visitantes == null) {
			visitantes = new ArrayList<>();
		}

		switch (tipo) {
			case 1: // Adulto
				if (visitante instanceof Adulto) {
					Adulto adulto = (Adulto) visitante;
					adulto.setTelefone(telefone);
					visitantes.add(adulto);
				} else {
					System.out.println("Tipo de visitante inválido.");
				}
				break;
			case 2: // Criança
				if (visitante instanceof Crianca) {
					Crianca crianca = (Crianca) visitante;
					crianca.setNome_responsavel(nomeResponsavel);
					crianca.setCodigo_ingresso(codigoIngresso);
					crianca.setTelefone_Responsavel(telefoneResponsavel);
					visitantes.add(crianca);
				} else {
					System.out.println("Tipo de visitante inválido.");
				}
				break;
			default:
				System.out.println("Tipo de visitante inválido.");
				break;
		}
	}

	public void listarVisitantes() {
		if (visitantes == null || visitantes.isEmpty()) {
			System.out.println("Nenhum visitante cadastrado.");
		} else {
			System.out.println("Visitantes cadastrados:");
			for (Visitante visitante : visitantes) {
				System.out.println(visitante);
			}
		}
	}

}
