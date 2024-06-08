public class Atracao {
    private String nome;
    private int capacidade;
    private int visitas;

    public Atracao(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
        visitas = 0;


    }

    public void setVisitas(int v) {
        visitas = v;
    }

    public void incrVisistas() {
        visitas++;
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

    public int getVisitas() {
        return visitas;
    }

}


