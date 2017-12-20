
package Feira;

public class Itens {
    private int quantidade;
    private Produto produto;
    
    // construtor da classe
    public Itens(Produto produto, int quantidade) {
        this.quantidade = quantidade;
        this.produto = produto;
    }    

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    //sobrescrita do metodo, para formatar a maneira como os dados serão apresentados
    @Override
    public String toString() {
        Menus.linha2();
        return String.format("|%06d   %-31s R$ %8.2f           %6d      R$ %8.2f|",produto.getCodigo(), produto.getNome(), produto.getPreco(), quantidade, quantidade * produto.getPreco());
    }
}
