import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Parque app = new Parque(500);
        Sistema sistema = new Sistema(app);
        sistema.exibirMenu();
         /* Cadastrar e imprimir lista de 3 visitantes
        for(int i = 0; i<3; i++){
        app.cadastrarVisitante();
        }
        app.listarVisitantes();
       */
        System.out.println();
        scan.close();
    }
}