import java.util.Scanner;

public class Sistema {
    private Parque parque;
    private Scanner scanner;

    public Sistema(Parque parque) {
        this.parque = parque;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = 0;
        do {
            System.out.println("Menu do Parque de Diversões:");
            System.out.println("1. Cadastrar novo visitante");
            System.out.println("2. Listar visitantes cadastrados");
            System.out.println("3. Emitir novo ingresso");
            System.out.println("4. Registrar visita a atração");
            System.out.println("5. Localizar visitante");
            System.out.println("6. Consultar faturamento");
            System.out.println("7. Consultar visitas por data");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    parque.cadastrarVisitante();
                    break;
                case 2:
                    parque.listarVisitantes();
                    break;
                case 3:
                    emitirIngresso();
                    break;
                case 4:
                    registrarVisitaAtracao();
                    break;
                case 5:
                    localizarVisitante();
                    break;
                case 6:
                    consultarFaturamento();
                    break;
                case 7:
                    consultarVisitasPorData();
                    break;
                case 8:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 8);
    }


    private void emitirIngresso() {
        System.out.print("Nome do visitante: ");
        String nome = scanner.nextLine();
        Visitante visitante = parque.pesquisaVisitanteNome(nome);
        if (visitante != null) {
            parque.emitirIngresso(visitante);
            System.out.println("Ingresso emitido com sucesso!");
        } else {
            System.out.println("Visitante não encontrado.");
        }
    }

    private void registrarVisitaAtracao() {
        System.out.print("Nome do visitante: ");
        String nome = scanner.nextLine();
        Visitante visitante = parque.pesquisaVisitanteNome(nome);
        if (visitante != null) {
            System.out.print("Nome da atração: ");
            String nomeAtracao = scanner.nextLine();
            Atracao atracao = parque.pesquisaAtracao(nomeAtracao);
            if (atracao != null) {
                visitante.visitar(atracao);
                System.out.println("Visita registrada com sucesso!");
            } else {
                System.out.println("Atração não encontrada.");
            }
        } else {
            System.out.println("Visitante não encontrado.");
        }
    }

    private void localizarVisitante() {
        System.out.print("Nome do visitante ou número do ingresso: ");
        String entrada = scanner.nextLine();
        Visitante visitante = parque.pesquisaVisitanteNome(entrada);
        if (visitante == null) {
            try {
                int numeroIngresso = Integer.parseInt(entrada);
                visitante = parque.pesquisaVisitanteIngresso(numeroIngresso);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
            }
        }
        if (visitante != null) {
            System.out.println("Visitante encontrado: " + visitante);
            System.out.println("Atrações visitadas:");
            for (Atracao atracao : visitante.getAtracoesVisitadas()) {
                System.out.println(atracao);
            }
        } else {
            System.out.println("Visitante não encontrado.");
        }
    }

    private void consultarFaturamento() {
        System.out.print("Digite o mês para consulta do faturamento (1-12): ");
        int mes = scanner.nextInt();
        System.out.print("Digite o ano para consulta do faturamento: ");
        int ano = scanner.nextInt();

        double faturamento = parque.calcularFaturamento(mes, ano);
        System.out.println("Faturamento do mês " + mes + "/" + ano + ": R$ " + faturamento);
    }

    private void consultarVisitasPorData() {
        // Implementar a consulta de visitas por data
    }
}
