import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PDVApp {
    private static JFrame frame;
    private static JTextArea areaVenda;
    private static Venda vendaAtual;
    private static Map<String, Produto> produtos;
    private static Map<String, Cliente> clientes;

    public static void main(String[] args) {
        // Inicializando dados fictícios
        produtos = new HashMap<>();
        clientes = new HashMap<>();
        inicializarProdutos();
        inicializarClientes();

        // Criando a interface gráfica
        frame = new JFrame("Sistema de PDV");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menuVenda = new JMenu("Iniciar Venda");
        JMenu menuConsulta = new JMenu("Consulta NFC-e");
        JMenu menuFuncoes = new JMenu("Funções");

        // Itens do menu
        JMenuItem menuItemIniciarVenda = new JMenuItem("Nova Venda");
        JMenuItem menuItemConsultaNFCE = new JMenuItem("Histórico de NFC-e");
        JMenuItem menuItemCadastrarProduto = new JMenuItem("Cadastrar Produto");
        JMenuItem menuItemCadastrarCliente = new JMenuItem("Cadastrar Cliente");
        JMenuItem menuItemLimiteDesconto = new JMenuItem("Limite de Desconto");

        menuVenda.add(menuItemIniciarVenda);
        menuConsulta.add(menuItemConsultaNFCE);
        menuFuncoes.add(menuItemCadastrarProduto);
        menuFuncoes.add(menuItemCadastrarCliente);
        menuFuncoes.add(menuItemLimiteDesconto);

        menuBar.add(menuVenda);
        menuBar.add(menuConsulta);
        menuBar.add(menuFuncoes);
        frame.setJMenuBar(menuBar);

        // Area de exibição de venda
        areaVenda = new JTextArea(10, 40);
        areaVenda.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaVenda);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Definindo ações dos itens de menu
        menuItemIniciarVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarVenda();
            }
        });

        menuItemConsultaNFCE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultaNFCe();
            }
        });

        menuItemCadastrarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarProduto();
            }
        });

        menuItemCadastrarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarCliente();
            }
        });

        menuItemLimiteDesconto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limiteDesconto();
            }
        });

        // Exibindo o menu
        frame.setVisible(true);
    }

    // Inicializando dados fictícios para produtos e clientes
    private static void inicializarProdutos() {
        produtos.put("12345", new Produto("12345", "Camiseta", 50.0));
        produtos.put("67890", new Produto("67890", "Calça", 80.0));
        produtos.put("11121", new Produto("11121", "Tênis", 120.0));
    }

    private static void inicializarClientes() {
        clientes.put("12345678901", new Cliente("João Silva", "12345678901"));
        clientes.put("98765432100", new Cliente("Maria Souza", "98765432100"));
    }

    // Funcionalidade de Iniciar Venda
    private static void iniciarVenda() {
        vendaAtual = new Venda();
        areaVenda.setText("Iniciando nova venda...\n");
        String codigoProduto = JOptionPane.showInputDialog(frame, "Digite o código de barras ou nome do produto:");

        Produto produto = produtos.get(codigoProduto);
        if (produto == null) {
            // Não encontrado pelo código, buscar pelo nome
            for (Produto p : produtos.values()) {
                if (p.getNome().equalsIgnoreCase(codigoProduto)) {
                    produto = p;
                    break;
                }
            }
        }

        if (produto != null) {
            vendaAtual.adicionarProduto(produto);
            areaVenda.append("Produto adicionado: " + produto.getNome() + " - R$ " + produto.getPreco() + "\n");
        } else {
            areaVenda.append("Produto não encontrado!\n");
        }
    }

    // Função para consultar NFC-e (histórico)
    private static void consultaNFCe() {
        areaVenda.setText("Consultando histórico de NFC-e...\n");
        // Simulação de histórico
        areaVenda.append("NFC-e 001: 15/10/2024 - João Silva - Total: R$ 250.00\n");
        areaVenda.append("NFC-e 002: 16/10/2024 - Maria Souza - Total: R$ 180.00\n");
    }

    // Função para cadastrar novo produto
    private static void cadastrarProduto() {
        String codigo = JOptionPane.showInputDialog(frame, "Digite o código do produto:");
        String nome = JOptionPane.showInputDialog(frame, "Digite o nome do produto:");
        double preco = Double.parseDouble(JOptionPane.showInputDialog(frame, "Digite o preço do produto:"));
        
        Produto novoProduto = new Produto(codigo, nome, preco);
        produtos.put(codigo, novoProduto);
        
        areaVenda.setText("Produto cadastrado: " + novoProduto.getNome() + "\n");
    }

   
