package application.usecase;

import domain.entities.Pedido;
import domain.repositories.Repositorypedido;

import java.util.Optional;

public class CancelaPedidosUseCase {

    private final Repositorypedido repositorypedido;

    public CancelaPedidosUseCase(Repositorypedido repositorypedido){
        this.repositorypedido = repositorypedido;
    }

    public Pedido executar(int numero){
        Optional<Pedido>pedidoOptional = repositorypedido.buscarNumero(numero);

        if (pedidoOptional.isEmpty())
            throw new IllegalArgumentException("Pedido número" + numero + "não encontrado.");


        Pedido pedido = pedidoOptional.get();
        pedido.cancelar();
        repositorypedido.atualiza(pedido);
        return pedido;



    }

}
