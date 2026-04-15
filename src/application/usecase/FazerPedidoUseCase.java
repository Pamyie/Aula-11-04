package application.usecase;

import application.dto.FazerPedido;
import domain.entities.Cliente;
import domain.entities.Pedido;
import domain.entities.Produto;
import domain.repositories.Repositorypedido;

import java.util.List;

public class FazerPedidoUseCase {

    private Repositorypedido repositoryPedido;

    public FazerPedidoUseCase(Repositorypedido repositoryPedido) {
        this.repositoryPedido = repositoryPedido;
    }

    public Pedido execute(FazerPedido request){
        validarRequest(request);

        Cliente cliente = new Cliente(request.getNomeCliente(), request.getCpfCliente());
        Pedido pedido = new Pedido(repositoryPedido.proximoNumero(), cliente);

        List<String> nomes = request.getNomesProdutos();
        List<Double> valores = request.getPrecosProdutos();
        List<Integer> estoques = request.getEstoquesProdutos();

        for (int i = 0; i < nomes.size(); i++){
            Produto produto = new Produto(nomes.get(i), valores.get(i), estoques.get(i));
            pedido.addProduto(produto);
        }

        pedido.fecharPedido();
        repositoryPedido.salvar(pedido);
        return pedido;

    }

    private void validarRequest(FazerPedido request){
        if (request == null){
            throw new IllegalArgumentException("Requisição não pode ser nula.");
        }
        if (request.getNomesProdutos() == null || request.getNomesProdutos().isEmpty()){
            throw new IllegalArgumentException("Informe ao menos um produto.");
        }
        if (request.getNomesProdutos().size() != request.getPrecosProdutos().size()
        || request.getNomesProdutos().size() != request.getEstoquesProdutos().size()){
            throw new IllegalArgumentException("Dados de produtos inconsistentes.");
        }
    }

}
