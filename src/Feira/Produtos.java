package Feira;

import java.util.ArrayList;

public abstract class Produtos {

    private static ArrayList<Produto> produtos = new ArrayList();

    // percorre a lista de produtos e verifica se o produto existe, lança o exception caso contrario
    public static Produto getProduto(int ID) throws Exception {
        Produto produto;
        for (int i = 0; i < produtos.size(); i++) {
            produto = produtos.get(i);
            if (produto.getCodigo() == ID) {
                return produto;
            }
            
        }
        throw new Exception("\nProduto não encontrado");
    }

    // retorna a lista de produtos
    public static ArrayList<Produto> getlista() {
        return produtos;
    }

    // adiciona um produto a lista
    public static void addProduto(Produto p) {
        produtos.add(p);
        System.out.println("\nProduto Adicionado com Sucesso\n");
    }

    // remove um produto da lista
    public static void removeProduto(Produto p) {
        produtos.remove(p);
        System.out.println("\nProduto Removido com Sucesso\n");
    }

    // imprime a lista de produtos
    public static void imprimeLista() throws Exception {
        for (int i = 0; i < produtos.size(); i++) {
            System.out.println(produtos.get(i));
        }
        if (produtos.isEmpty()) {
            throw new Exception("|                        Não Há Produtos                    |\n");
        }
    }
}
