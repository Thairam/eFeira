package Feira;

import java.util.Scanner;
// Classe onde criei alguns Mecanismos que me ajudaram na organização e apresentação do programa

public abstract class Menus {
    Scanner s = new Scanner(System.in);
    
    public static void menuPrincipal() {
        System.out.println("=============================\n" + "| Informe a opção           |");
        System.out.println("| 1 - Ver Produtos a venda  |"
                + "\n| 2 - Administrar o estoque |"
                + "\n=============================");
    }
    
    public static void Comprar(){
        System.out.printf("\n=============================================================");
        System.out.println("\n| 1 - Para comprar                     0 - Finalizar Compra |");
        System.out.printf("=============================================================\n");
    }
    
    public static void orgEstoque() {
         System.out.printf("============================================================ ");
        System.out.println("\n| 1 - Adicionar Produtos               2 - Remover Produtos|"
                + "\n| 3 - Editar Estoque                   0 - Para Sair       |");
        System.out.printf("============================================================\n");
    }

    public static void admin() {
        System.out.printf("============================================================ ");
        System.out.println("\n| 1 - Organizar Estoque           2 - Ver Rendimento Atual |"
                + "\n| 0 - Menu Inicial                                         |");
        System.out.printf("============================================================\n");

    }

    public static void editEstoque() {
        System.out.printf("=============================================================");
        System.out.println("\n| 1 - Adicionar Estoque                  2 - Remover Estoque|");
        System.out.printf("=============================================================\n");

    }
    
    public static void linha() {
        System.out.println("=============================================================");
    }

    public static void linha2() {
        System.out.println("========================================================================================");
    }
    public static void linha3() {
        System.out.println("===========================================");
    }

    public static void listaProdutos() throws Exception {
       try{ 
        System.out.println("=============================================================");
        System.out.println("|   ID                  Produto            Estq        Valor|");
        Menus.linha();
        Produtos.imprimeLista();
        Menus.linha();
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
    }
}
