
package Feira;

import java.util.ArrayList;

public class Pedido {
    private int ID;
    private static int cont = 1;
    
    private ArrayList<Itens> itens = new ArrayList();
    
    // Faz com o que o ID de cada pedido seja único
    public Pedido() {
        this.ID = cont;
        cont++;
    }
    

   // insere o item na lista de itens
   public void inserirItem(Itens i){
       itens.add(i);
   }
   
   // retorna o total do pedido
   public double totalpedido(Pedido v){
       double total = 0;
       for (int i = 0; i < itens.size(); i++) {
           total+= itens.get(i).getQuantidade()* itens.get(i).getProduto().getPreco();
       }
        return total;
   }
   
   // retorna o lucro do pedido
      public double lucropedido(Pedido v){
       double total = 0;
       for (int i = 0; i < itens.size(); i++) {
           total+= itens.get(i).getQuantidade()* (itens.get(i).getProduto().getPreco() - itens.get(i).getProduto().getCusto());
       }
        return total;
   }

    public int getID() {
        return ID;
    }

    //sobrescrita do metodo para formatar a maneira como é apresentado o ID do pedido
    @Override
    public String toString() {
        return String.format(" %06d", ID);
    }
    
    public void imprimirPedido(){
        double valor = 0;
        Menus.linha2();
        System.out.println("|Codigo do Pedido: " + this.toString() + "                                                             |");
        System.out.println("|Codigo   Produto                            Preço          Quantidade      Valor Total|");
        for (int i = 0; i < itens.size(); i++) {
            System.out.println(itens.get(i));
            valor+= ((itens.get(i).getProduto().getPreco()) * (itens.get(i).getQuantidade()));
        }
        
        Menus.linha2();
        System.out.println("|                                                          Valor do Pedido: R$ " + String.format("%8.2f|",valor));
        Menus.linha2();
    }
}
