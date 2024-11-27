import java.util.List;

public interface CrudRepository<T> {
    void criar(T t);
    List<T> listar();
    void atualizar(T t);
    void deletar(T t);
}