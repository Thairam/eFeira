package Feira;

import java.util.ArrayList;

public abstract class Pedidos {

    private static ArrayList<Pedido> pedidos = new ArrayList();

    //percorre a lista de pedidos e verifica se o pedido existe, lança o exception caso o contrário
    public static Pedido getPedido(int ID) throws Exception {
        Pedido pedido;
        for (int i = 0; i < pedidos.size(); i++) {
            pedido = pedidos.get(i);
            if (pedido.getID() == ID) {
                return pedido;
            }
        }
        throw new Exception("Pedido não encontrado");
    }
    
    //retorna o valor das vendas já efetuadas
    public static double getVendas() {
        double valor = 0;
        Pedido pedido;
        for (int i = 0; i < pedidos.size(); i++) {
            pedido = pedidos.get(i);
            valor += pedido.totalpedido(pedido);
        }
        return valor;
    }
    
    // retorna o lucro de todos os pedidos
    public static double getLucro() {
        double lucro = 0;
        Pedido pedido;
        for (int i = 0; i < pedidos.size(); i++) {
            pedido = pedidos.get(i);
            lucro += pedido.lucropedido(pedido);
        }
        return lucro;
    }

    //retorna a lista de pedidos
    public static ArrayList<Pedido> getListaPedidos() {
        return pedidos;
    }

    //adiciona um pedido a lista de pedidos 
    public static void addPedido(Pedido p) throws Exception{
        if(p.itens.isEmpty()){
           throw new Exception("\nCarrinho Vazio"); 
        }
        pedidos.add(p);
    }

    public static void imprimePedido() throws Exception{
        for (int i = 0; i < pedidos.size(); i++) {
            System.out.println(pedidos.get(i));
        }
        if(pedidos.isEmpty()){
            throw new Exception("Pedido não encontrado");
        }
    }
}
