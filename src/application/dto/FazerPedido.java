package application.dto;

import java.util.List;

public class FazerPedido {
    private String nomeCliente;
    private String cpfCliente;
    private List<String> nomesProdutos;
    private List<Double> precosProdutos;
    private List<Integer> estoquesProdutos;

    public FazerPedido(String nomeCliente, String cpfCliente, List<String> nomes,
                       List<Double> precos, List<Integer> estoques) {
        if(nomes == null || nomes.isEmpty())
           throw new IllegalArgumentException("Informe um produto.");

        if (nomes.size() != precos.size() || nomes.size() != estoques.size())
            throw new IllegalArgumentException("Dados estão inconsistentes.");

        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.nomesProdutos = nomes;
        this.precosProdutos = precos;
        this.estoquesProdutos = estoques;
    }

    public String getNomeCliente() { return nomeCliente; }

    public String getCpfCliente() { return cpfCliente; }

    public List<String> getNomesProdutos() { return nomesProdutos; }

    public List<Double> getPrecosProdutos() { return precosProdutos; }

    public List<Integer> getEstoquesProdutos() { return estoquesProdutos; }

}
