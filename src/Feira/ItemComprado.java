package Feira;

public class ItemComprado {

    private double preco;
    private double custo;
    private String nome;
    private int ID;
    private int estoque = 0;
    private static int cont = 1;

    // faz com que o item comprado tenha um ID unico
    public ItemComprado() {
        this.ID = cont;
        cont++;
    }

    public ItemComprado(double preco, double custo, String nome, int ID) {
        this.preco = preco;
        this.custo = custo;
        this.nome = nome;
        this.ID = ID;
    }
    
    
    
    // aumenta o estoque do item comprado
    public void aumentarEstoque(int quantidade) throws Exception {
        this.estoque = estoque + quantidade;
    }
    
    //diminui o estoque do item comprado
    public void diminuirEstoque(int quantidade) throws Exception {
        if (this.estoque == 0 || quantidade > this.estoque) {
            throw new Exception("\nEstoque Indisponível\n");
        } else {
            this.estoque = estoque - quantidade;
        }
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }


}
