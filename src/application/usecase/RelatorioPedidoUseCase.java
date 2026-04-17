package application.usecase;

import domain.entities.Pedido;
import domain.repositories.Repositorypedido;

import java.util.List;

public class RelatorioPedidoUseCase {

    private final Repositorypedido repositorypedido;

    public RelatorioPedidoUseCase(Repositorypedido repositorypedido){
        this.repositorypedido = repositorypedido;
    }

    public RespostaRelatorio executar(){
        List<Pedido> pedidos = repositorypedido.listar();

        int totalPedidos = 0;
        int cancelados = 0;
        double receitaTotal = 0;
        double receitaTotalCancelada = 0;

        for (Pedido pedido : pedidos){
            totalPedidos++;

            if (pedido.getStatuspedido().equals("cancelado")){
                cancelados++;
                receitaTotalCancelada += pedido.getTotal();
            }else {
                receitaTotal += pedido.getTotal();
            }
        }
        return new RespostaRelatorio(totalPedidos, cancelados, receitaTotal, receitaTotalCancelada);
    }



}
