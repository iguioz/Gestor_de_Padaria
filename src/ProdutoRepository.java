import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository implements CrudRepository<Produto> {
    private List<Produto> produtos = new ArrayList<>();

    @Override
    public void criar(Produto produto) {
        produtos.add(produto);
    }

    @Override
    public List<Produto> listar() {
        return produtos;
    }

    @Override
    public void atualizar(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getNome().equals(produto.getNome())) {
                produtos.set(i, produto);
                break;
            }
        }
    }

    @Override
    public void deletar(Produto produto) {
        produtos.remove(produto);
    }
}
