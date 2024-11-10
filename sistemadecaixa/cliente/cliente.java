// Cliente.java
public class Cliente {
    private String nome;
    private String cpf;

    // Construtor
    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Métodos de acesso (getters)
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    // Método toString para exibição
    @Override
    public String toString() {
        return nome + " (" + cpf + ")";
    }
}