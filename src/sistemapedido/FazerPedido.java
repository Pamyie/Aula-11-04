package sistemapedido;

import java.util.List;

public class FazerPedido {
    private String nomeCliente;
    private String cpfCliente;
    private List<String> nomesProdutos;
    private List<Double> precosProdutos;
    private List<Integer> estoquesProdutos;

    public FazerPedido(String nomeCliente, String cpfCliente, List<String> nomesProdutos,
                       List<Double> precosProdutos, List<Integer> estoquesProdutos) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.nomesProdutos = nomesProdutos;
        this.precosProdutos = precosProdutos;
        this.estoquesProdutos = estoquesProdutos;
    }

    public String getNomeCliente() { return nomeCliente; }

    public String getCpfCliente() { return cpfCliente; }

    public List<String> getNomesProdutos() { return nomesProdutos; }

    public List<Double> getPrecosProdutos() { return precosProdutos; }

    public List<Integer> getEstoquesProdutos() { return estoquesProdutos; }

}
