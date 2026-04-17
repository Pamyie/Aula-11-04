package application.usecase;

import domain.entities.Pedido;
import domain.repositories.Repositorypedido;

import java.util.List;

public class ListarPedidosUseCase {

    private Repositorypedido repositoryPedido;

    public ListarPedidosUseCase(Repositorypedido repositoryPedido){
        this.repositoryPedido = repositoryPedido;
    }

    public List<Pedido> execute(){
        return repositoryPedido.listar();
    }
}
