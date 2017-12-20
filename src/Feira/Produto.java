package Feira;

public class Produto {

    private double preco;
    private double custo;
    private String nome;
    private int codigo;
    private int estoque = 0;
    private static int cont = 1;

    // faz com que o codigo do produto seja unico
    public Produto() {
        this.codigo = cont;
        cont++;
    }

    // decrementa o estoque após uma compra
    public void diminuirEstoque(int quantidade) throws Exception {
        if (this.estoque ==0 || quantidade > this.estoque) {
            throw new Exception("\nEstoque Indisponível\n");
        } else {
            this.estoque = estoque - quantidade;
        }
    }
    
    // adiciona uma quantidade determinada ao estoque
    public void aumentarEstoque(int quantidade) throws Exception {
        this.estoque = estoque + quantidade;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo){
        this.custo = custo;
    }
    
    //sobrescrita do metodo, utilizada para formatar a apresentação dos atributos da classe
    @Override
    public String toString() {
        return String.format("| %06d", codigo)
                + String.format(" %-31s", nome)
                + String.format(" %5d", estoque)
                + String.format("   R$ %,8.2f|", preco);
    }

}
