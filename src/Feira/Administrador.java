package Feira;

public class Administrador {

    private String nome;
    private String senha;
    private boolean autenticado;

    public Administrador(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    
    // retorna ture caso consgia autenticar, e false caso não consiga
    public boolean autentica(String nome, String senha) {
        if (this.nome.equals("Admin") && (this.senha.equals("admin"))) {
            autenticado = true;
            System.out.println("\nAutenticado\n");
            return true;
        } else {
            System.out.println("\nNão Autenticado\n");
            return false;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
