package application.usecase;

import domain.entities.Pedido;
import domain.repositories.Repositorypedido;

import java.util.Optional;

public class BuscarPedidoUseCase {

    private Repositorypedido repositorypedido;

    public BuscarPedidoUseCase(Repositorypedido repositorypedido){
        this.repositorypedido = repositorypedido;
    }

    public Pedido executar(int numero){
        if (numero < 0){
            throw new IllegalArgumentException("Numero inválido.");
        }

        Optional<Pedido> pedido = repositorypedido.buscarNumero(numero);

        if (pedido.isEmpty()){
            throw new IllegalArgumentException("Pedido número " + numero + "não encontrado.");
        }
        return pedido.get();
    }


}
