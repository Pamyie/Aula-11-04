import adapters.controllers.ControllerPedido;
import application.usecase.*;
import infrastructure.repositories.RepositoryMemoryPedido;


public class Main {

    public static void main(String[] args) {
        RepositoryMemoryPedido repository = new RepositoryMemoryPedido();
        FazerPedidoUseCase fazerPedidoUseCase = new FazerPedidoUseCase(repository);
        ListarPedidosUseCase listarPedidosUseCase = new ListarPedidosUseCase(repository);
        BuscarPedidoUseCase buscarPedidoUseCase = new BuscarPedidoUseCase(repository);
        CancelaPedidosUseCase cancelaPedidosUseCase = new CancelaPedidosUseCase(repository);
        RelatorioPedidoUseCase relatorioPedidoUseCase = new RelatorioPedidoUseCase(repository);

        ControllerPedido controller = new ControllerPedido(fazerPedidoUseCase, listarPedidosUseCase, buscarPedidoUseCase,
                cancelaPedidosUseCase, relatorioPedidoUseCase);
        controller.iniciar();
    }


}
