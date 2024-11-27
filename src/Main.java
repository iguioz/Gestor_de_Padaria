import java.util.*;

public class Main {
    public static void main(String[] args) {

        ProdutoRepository produtoRepo = new ProdutoRepository();
        PessoaRepository pessoaRepo = new PessoaRepository();
        PedidoRepository pedidoRepo = new PedidoRepository();


        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println("\n--- MENU ---");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Adicionar Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Fazer Pedido");
            System.out.println("6. Listar Pedidos");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:

                    System.out.print("Digite o nome do produto: ");
                    String nomeProduto = scanner.nextLine();
                    System.out.print("Digite o preço do produto: ");
                    double precoProduto = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Escolha a categoria:");
                    for (CategoriaProduto categoria : CategoriaProduto.values()) {
                        System.out.println(categoria.ordinal() + ". " + categoria.getDescricao());
                    }
                    System.out.print("Digite o número da categoria: ");
                    int categoriaEscolhida = scanner.nextInt();
                    scanner.nextLine();

                    Produto novoProduto = new Produto(nomeProduto, precoProduto, CategoriaProduto.values()[categoriaEscolhida]);
                    produtoRepo.criar(novoProduto);
                    System.out.println("Produto adicionado com sucesso!");
                    break;

                case 2:

                    System.out.println("Produtos na padaria:");
                    for (Produto produto : produtoRepo.listar()) {
                        System.out.println(produto);
                    }
                    break;

                case 3:

                    System.out.print("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("Digite o endereço do cliente: ");
                    String enderecoCliente = scanner.nextLine();
                    System.out.print("Digite o telefone do cliente: ");
                    String telefoneCliente = scanner.nextLine();

                    Pessoa novoCliente = new Pessoa(nomeCliente, enderecoCliente, telefoneCliente);
                    pessoaRepo.criar(novoCliente);
                    System.out.println("Cliente adicionado com sucesso!");
                    break;

                case 4:

                    System.out.println("Clientes cadastrados:");
                    for (Pessoa pessoa : pessoaRepo.listar()) {
                        System.out.println(pessoa);
                    }
                    break;

                case 5:
                    System.out.println("Escolha um cliente para o pedido:");
                    for (int i = 0; i < pessoaRepo.listar().size(); i++) {
                        System.out.println(i + ". " + pessoaRepo.listar().get(i).getNome());
                    }
                    System.out.print("Digite o número do cliente: ");
                    int clienteEscolhido = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha pendente

                    Pessoa cliente = pessoaRepo.listar().get(clienteEscolhido);

                    System.out.println("Escolha os produtos para o pedido:");
                    for (int i = 0; i < produtoRepo.listar().size(); i++) {
                        System.out.println(i + ". " + produtoRepo.listar().get(i).getNome());
                    }

                    List<Produto> produtosDoPedido = new ArrayList<>();
                    while (true) {
                        System.out.print("Digite o número do produto para adicionar ao pedido (ou -1 para finalizar): ");

                        // Verifica se o input é um número
                        if (!scanner.hasNextInt()) {
                            System.out.println("Entrada inválida! Por favor, insira um número.");
                            scanner.nextLine();  // Consumir a entrada inválida
                            continue;
                        }

                        int produtoEscolhido = scanner.nextInt();
                        scanner.nextLine();  // Consumir a nova linha pendente

                        if (produtoEscolhido == -1) {
                            break;  // Finaliza a escolha dos produtos
                        }

                        if (produtoEscolhido < 0 || produtoEscolhido >= produtoRepo.listar().size()) {
                            System.out.println("Número inválido. Escolha novamente.");
                        } else {
                            produtosDoPedido.add(produtoRepo.listar().get(produtoEscolhido));
                            System.out.println("Produto adicionado ao pedido.");
                        }
                    }

                    Pedido novoPedido = new Pedido(cliente, produtosDoPedido);
                    pedidoRepo.criar(novoPedido);
                    System.out.println("Pedido feito com sucesso!");
                    break;


                case 6:

                    System.out.println("Pedidos realizados:");
                    for (Pedido pedido : pedidoRepo.listar()) {
                        System.out.println(pedido);
                        System.out.println("Total do pedido: R$ " + pedido.calcularTotal());
                    }
                    break;

                case 7:

                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}