package infrastructure.repositories;

import domain.entities.Pedido;
import domain.repositories.Repositorypedido;

import java.util.ArrayList;
import java.util.List;

public class RepositoryMemoryPedido implements Repositorypedido {

    private List<Pedido> pedidos = new ArrayList<Pedido>();

    public void salvar(Pedido pedido){
        pedidos.add(pedido);
    }

    public List<Pedido> listar(){
        return pedidos;
    }
    public int proximoNumero(){
        return pedidos.size() + 1;
    }


}
