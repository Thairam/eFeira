package Feira;
/*
Docente: Danilo Abreu       Disciplina: LPII (Programação Orientada a Objetos)  linguagem Utilizada:    Java
Aluno: Thairam Michel Santos Ataide     Curso: Ciências da Computação       Turno: Noite
Tarefa: Além de Transmitir conhecimento a tarefa tem o objetivo de fazer com que o aluno com o que lhe foi apresentado 
em sala de aula, simule um sistema de "Feira" com mecanismos muito similares que simulam um sistema de compra, venda e organização de estoque.
*/
import java.util.InputMismatchException;
import java.util.Scanner;

public class TesteVendas {

    public static void main(String[] args) throws Exception {
        while (true) {
            int quantidade = 0;
            Scanner s = new Scanner(System.in);
            Menus.menuPrincipal();
            int op = s.nextInt();

            if (op == 1) {
                try {
                    Menus.listaProdutos();

                    while (true) {
                        if (Produtos.getlista().isEmpty()) {
                            break;
                        }

                        do {
                            Menus.Comprar();
                            op = s.nextInt();
                        } while (op < 0 || op > 1);

                        if (op == 1) {
                            Pedido p = new Pedido();
                            do {
                                try {
                                    System.out.printf("\nInforme o ID do produto: ");
                                    Produto prod = Produtos.getProduto(s.nextInt());
                                    System.out.printf("Informe a quantidade: ");
                                    quantidade = s.nextInt();
                                    p.inserirItem(new Itens(prod, quantidade));
                                    prod.diminuirEstoque(quantidade);
                                    System.out.println("\nProduto Adicionado ao Carrinho");
                                    Menus.listaProdutos();
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                }
                                Menus.Comprar();
                                op = s.nextInt();
                            } while (op != 0);

                            Pedidos.addPedido(p);
                            Pedidos.getListaPedidos();
                            p.imprimirPedido();

                        } else {
                            if (Pedidos.getListaPedidos().isEmpty()) {
                                break;
                            } else {
                                System.out.println("\nCompra efetuada com Sucesso\n");
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } else if (op == 2) {
                // Administrar o estoque
                s.nextLine(); //limpar buffer do teclado
                boolean ativar = true;

                while (ativar == true) {
                    System.out.printf("Login: ");
                    String login = s.nextLine();
                    System.out.printf("Senha: ");
                    String senha = s.nextLine();
                    Administrador adm = new Administrador(login, senha);
                    if (adm.autentica(login, senha) == true) {
                        ativar = false;
                    }
                }

                OUTER:
                while (true) {
                    do {
                        Menus.admin();
                        op = s.nextInt();
                    } while (op < 0 || op > 5);
                    
                    if (op == 0) {
                        break;
                    }
                    
                    switch (op) {
                        case 1:
                            do {
                                Menus.orgEstoque();
                                op = s.nextInt();
                            } while (op < 0 || op > 3);
                            
                            if (op == 0) {
                                break OUTER;
                            }
                            
                            switch (op) {
                                case 1:
                                    // limpando o buffer do teclado
                                    s.nextLine();
                                    // add produtos
                                    ItemComprado itemcomprado = new ItemComprado();
                                    Produto produt = new Produto();
                                    try {
                                        System.out.printf("Descricao produto: ");
                                        String nome = s.nextLine();
                                        produt.setNome(nome);
                                        itemcomprado.setNome(nome);
                                        System.out.printf("Valor do Produto: ");
                                        double custo = s.nextDouble();
                                        produt.setCusto(custo);
                                        itemcomprado.setCusto(custo);
                                        System.out.printf("Valor de venda do produto: ");
                                        double valor = s.nextDouble();
                                        produt.setPreco(valor);
                                        itemcomprado.setPreco(valor);
                                        System.out.print("estoque: ");
                                        int estoque = s.nextInt();
                                        produt.setEstoque(estoque);
                                        itemcomprado.setEstoque(estoque);
                                        Produtos.addProduto(produt);
                                        ItensComprados.inserirItem(itemcomprado);
                                    } catch (InputMismatchException e) {
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                case 2:
                                    try {
                                        Menus.listaProdutos();
                                        //remover produtos
                                        if (Produtos.getlista().isEmpty()) {
                                            break;
                                        }
                                        
                                        System.out.println("\nInforme o ID do produto: ");
                                        Produto prod = Produtos.getProduto(s.nextInt());
                                        Produtos.removeProduto(prod);
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                case 3:
                                    // editar produtos no estoque(modificar a quantidade de produtos já existentes)
                                    Menus.editEstoque();
                                    op = s.nextInt();
                                    if (op == 1) {
                                        int ID;
                                        try {
                                            Menus.listaProdutos();
                                            if (Produtos.getlista().isEmpty()) break;
                                            System.out.println("Informe o ID do produto: ");
                                            ID = s.nextInt();
                                            Produto prod = Produtos.getProduto(ID);
                                            ItemComprado itemc = ItensComprados.getIten(ID);
                                            System.out.println("Informe a Quantidade: ");
                                            quantidade = s.nextInt();
                                            prod.aumentarEstoque(quantidade);
                                            itemc.aumentarEstoque(quantidade);
                                            System.out.println("\nQuantidade Adicionada");
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }

                                    } else if (op == 2) {
                                        int ID = 0;
                                        try {
                                            Menus.listaProdutos();
                                            if (Produtos.getlista().isEmpty()) {
                                                break;
                                            }
                                            System.out.println("Informe o ID do produto: ");
                                            ID = s.nextInt();
                                            Produto prod = Produtos.getProduto(ID);
                                            ItemComprado itemc = ItensComprados.getIten(ID);
                                            System.out.println("Informe a Quantidade: ");
                                            quantidade = s.nextInt();
                                            prod.diminuirEstoque(quantidade);
                                            itemc.diminuirEstoque(quantidade);
                                            System.out.println("\nQuantidade Removida");

                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
                                        }
                                    }
                                    break;
                                default:
                                    break;
                            }
                            break;
                        case 2:
                            // ver rendimento atual
                            Menus.linha3();
                            System.out.println("| Total em Abastecimento: " + String.format("   R$ %,8.2f |", ItensComprados.valorEstoque()));
                            System.out.println("| Total em vendas: " + String.format("          R$ %,8.2f |", Pedidos.getVendas()));
                            System.out.println("| Lucro: " + String.format("                    R$ %,8.2f |", Pedidos.getLucro()));
                            System.out.println("| Lucro em [%]: " + String.format("                 %,7.2f%% |", (Pedidos.getLucro() * 100) / Pedidos.getVendas()));
                            Menus.linha3();
                            break;
                        default:
                            break OUTER;
                    }
                }
            }
        }
    }
}
