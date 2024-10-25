package Tarefa1_Contatos;

public class Contatinho {
    private String nome;
    private String email;
    private String telefone;
    private String categoria;

    public Contatinho(String nome, String email, String telefone, String categoria) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.categoria = categoria;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCategoria() {
        return categoria;
    }

    // Representação no formato para salvar no arquivo
    @Override
    public String toString() {
        return nome + "#" + email + "#" + telefone + "#" + categoria;
    }

    // Método para criar um Contatinho a partir de uma linha do arquivo
    public static Contatinho fromString(String linha) {
        String[] dados = linha.split("#");
        return new Contatinho(dados[0], dados[1], dados[2], dados[3]);
    }
}
