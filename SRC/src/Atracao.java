public class Atracao {
    private String nome;
    private int capacidade;
    private int visistas;

    public Atracao(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        visistas = 0;


    }

    public void incrVisistas() {
        visistas++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }


