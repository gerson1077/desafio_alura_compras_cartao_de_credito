public class Compra implements Comparable<Compra>{
    private String descricao;
    private double valor;

    public Compra(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Compra: " +
                "descricao='" + descricao +
                ", valor = " + valor +
                '}';
    }

    //método para implementar a ordenação
    @Override
    public int compareTo(Compra outraCompra) {
        return this.getDescricao().compareTo(outraCompra.getDescricao());
    }
}
