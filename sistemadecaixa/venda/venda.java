import java.util.ArrayList;
import java.util.List;

public class Venda {
    private List<Produto> produtosVendidos;
    private Cliente cliente;
    private double totalVenda;
    private boolean finalizada;

    public Venda() {
        produtosVendidos = new ArrayList<>();
        totalVenda = 0.0;
        finalizada = false;
    }

    public void adicionarProduto(Produto produto) {
        if (!finalizada) {
            produtosVendidos.add(produto);
            totalVenda += produto.getPreco();
        }
    }

    public void cancelarProduto(Produto produto) {
        if (!finalizada && produtosVendidos.remove(produto)) {
            totalVenda -= produto.getPreco();
        }
    }

    public void finalizarVenda() {
        finalizada = true;
    }

    public void cancelarVenda() {
        produtosVendidos.clear();
        totalVenda = 0.0;
        finalizada = false;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    public List<Produto> getProdutosVendidos() {
        return produtosVendidos;
    }

    public boolean isFinalizada() {
        return finalizada;
    }
}
