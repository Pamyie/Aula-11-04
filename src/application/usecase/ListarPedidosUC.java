package application.usecase;

import domain.entities.Pedido;
import domain.repositories.Repositorypedido;

import java.util.List;

public class ListarPedidosUC {

    private Repositorypedido repositoryPedido;

    public ListarPedidosUC(Repositorypedido repositoryPedido){
        this.repositoryPedido = repositoryPedido;
    }

    public List<Pedido> execute(){
        return repositoryPedido.listar();
    }
}
