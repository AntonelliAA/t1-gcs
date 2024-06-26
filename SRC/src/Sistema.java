import java.util.*;
import java.time.LocalDate;

public class Sistema {
    private Parque parque;
    private Scanner scanner;
    private LocalDate dataAtual;
    private Map<LocalDate,Parque> calendario = new HashMap<>();; //mapeia dias do funcionamento do parque
  //contem uma copia do parque ao final do dia, para poder ver quantas vezes foram visitadas

    private boolean novoDia = false;

    public Sistema(Parque parque) {
        this.parque = parque;
        this.scanner = new Scanner(System.in);
    }

    public boolean novoDiaComecou() {
        if (this.novoDia == false) {
            System.out.println("Voce deve iniciar o dia para poder usar essa opçao!");
            return false;
        }
        return true;
    }

    public void iniciarNovoDia() {
        dataAtual = LocalDate.now();
        System.out.println("Iniciando novo dia!");
        System.out.println("Hoje é dia " + dataAtual);
        System.out.println("Voce agora pode usar as outras opcoes");
        this.novoDia = true;
    }

    public void encerrarDia() {
        this.novoDia = false;
        System.out.println("Dia encerrado! Outras opcoes nao mais disponiveis");
        System.out.println("Consultando faturamento do dia: ");
        consultarFaturamento();
        calendario.put(dataAtual, parque);// adicionado o estado do parque ao final do dia, e reseta-lo
        parque.reset_diario(); // zeradas as visitas e visitantes
    }

    public void exibirMenu() {
        int opcao = 0;
        do {
            System.out.println("Menu do Parque de Diversões:");
            System.out.println("0. Iniciar novo dia");
            System.out.println("1. Cadastrar novo visitante");
            System.out.println("2. Listar visitantes cadastrados");
            System.out.println("3. Emitir novo ingresso");
            System.out.println("4. Registrar visita a atração");
            System.out.println("5. Localizar visitante");
            System.out.println("6. Consultar faturamento");
            System.out.println("7. Consultar visitas por data");
            System.out.println("8. Encerrar dia");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 0:
                    iniciarNovoDia();
                    break;
                case 1:
                    if (novoDiaComecou()) {
                        parque.cadastrarVisitante();
                    }
                    break;
                case 2:
                    if (novoDiaComecou()) {
                        parque.listarVisitantes();
                    }
                    break;
                case 3:
                    if (novoDiaComecou()) {
                        emitirIngresso();
                    }
                    break;
                case 4:
                    if (novoDiaComecou()) {
                        registrarVisitaAtracao();
                    }
                    break;
                case 5:
                    if (novoDiaComecou()) {
                        localizarVisitante();
                    }
                    break;
                case 6:
                    if (novoDiaComecou()) {
                        consultarFaturamento();
                    }
                    break;
                case 7:
                    if (novoDiaComecou()) {
                        consultarVisitasPorData(dataAtual);
                    }
                    break;
                case 8:
                    encerrarDia();
                    break;
                case 9:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 9);
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

    private void consultarVisitasPorData(LocalDate data_consulta) {
        Parque estado_passado = calendario.get(data_consulta);
        for (Atracao a : estado_passado.atracoes){ //ja estão ordenadas
            System.out.println("Nome: "+ a.getNome() + "Visitas: " + a.getVisitas());
        }

    }

}
