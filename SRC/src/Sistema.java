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
        // Implementar a emissão de novo ingresso
    }

    private void registrarVisitaAtracao() {
        // Implementar o registro de visita a uma atração
    }

    private void localizarVisitante() {
        // Implementar a localização de um visitante
    }

    private void consultarFaturamento() {
        // Implementar a consulta de faturamento
    }

    private void consultarVisitasPorData() {
        // Implementar a consulta de visitas por data
    }
}
