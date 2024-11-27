import java.util.List;

public class Pedido {
    private Pessoa cliente;
    private List<Produto> produtos;

    public Pedido(Pessoa cliente, List<Produto> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
    }

   
    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double calcularTotal() {
        return produtos.stream().mapToDouble(Produto::getPreco).sum();
    }

    @Override
    public String toString() {
        return "Pedido [cliente=" + cliente + ", produtos=" + produtos + "]";
    }
}
