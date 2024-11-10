// Produto.java
public class Produto {
    private String codigo;
    private String nome;
    private double preco;

    // Construtor
    public Produto(String codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }

    // Métodos de acesso (getters)
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    // Método toString para exibição
    @Override
    public String toString() {
        return nome + " - R$ " + preco;
    }
}
