package domain.repositories;

import domain.entities.Pedido;

import java.util.List;
import java.util.Optional;


public interface Repositorypedido {
    void salvar(Pedido pedido);
    void atualiza(Pedido pedido);
    List<Pedido> listar();
    int proximoNumero();
    Optional<Pedido> buscarNumero(int numero);
}
