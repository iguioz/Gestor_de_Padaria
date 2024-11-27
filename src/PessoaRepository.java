import java.util.ArrayList;
import java.util.List;

public class PessoaRepository implements CrudRepository<Pessoa> {
    private List<Pessoa> pessoas = new ArrayList<>();

    @Override
    public void criar(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    @Override
    public List<Pessoa> listar() {
        return pessoas;
    }

    @Override
    public void atualizar(Pessoa pessoa) {
        for (int i = 0; i < pessoas.size(); i++) {
            if (pessoas.get(i).getNome().equals(pessoa.getNome())) {
                pessoas.set(i, pessoa);
                break;
            }
        }
    }

    @Override
    public void deletar(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }
}