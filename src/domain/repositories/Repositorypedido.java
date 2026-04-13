package domain.repositories;

import domain.entities.Pedido;

import java.util.List;


public interface Repositorypedido {
    void salvar(Pedido pedido);
    List<Pedido> listar();
    int proximoNumero();

}
