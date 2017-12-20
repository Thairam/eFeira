package Feira;

import java.util.ArrayList;

public abstract class ItensComprados {

    private static ArrayList<ItemComprado> compras = new ArrayList();
    
    // percorre a lista de itens comprados verificando se o item existe
    public static ItemComprado getIten(int ID) throws Exception {
        ItemComprado item;
        for (int i = 0; i < compras.size(); i++) {
            item = compras.get(i);
            if (item.getID() == ID) {
                return item;
            }

        }
        throw new Exception("\nIten não encontrado");
    }

    // retorna o valor total gasto no abastecimento do estoque    
    public static double valorEstoque() {
        double valor = 0;
        for (int i = 0; i < compras.size(); i++) {
            valor += ((compras.get(i).getCusto()) * (compras.get(i).getEstoque()));
        }
        return valor;
    }

    // insere um item comprado na lista de itens
    public static void inserirItem(ItemComprado i) {
        compras.add(i);
    }


}
