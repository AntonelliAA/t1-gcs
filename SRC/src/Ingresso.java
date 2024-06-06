import java.time.LocalDate;

class Ingresso {
    private String id;
    private Visitante visitante;
    private LocalDate data;
    private double preco;

    public Ingresso(String id, Visitante visitante) {
        this.id = id;
        this.visitante = visitante;
        this.data = LocalDate.now();
        this.preco = visitante.getAnoNascimento() <= LocalDate.now().getYear() - 12 ? 80.0 : 100.0;
    }

    public Visitante getVisitante() {
        return visitante;
    }

    public LocalDate getData() {
        return data;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Ingresso{" +
                "id='" + id + '\'' +
                ", visitante=" + visitante +
                ", data=" + data +
                ", preco=" + preco +
                '}';
    }
}