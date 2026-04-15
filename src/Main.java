import adapters.controllers.ControllerPedido;
import application.usecase.FazerPedidoUseCase;
import application.usecase.ListarPedidosUC;
import infrastructure.repositories.RepositoryMemoryPedido;


public class Main {

    public static void main(String[] args) {
        RepositoryMemoryPedido repository = new RepositoryMemoryPedido();
        FazerPedidoUseCase fazerPedidoUseCase = new FazerPedidoUseCase(repository);
        ListarPedidosUC listarPedidosUC = new ListarPedidosUC(repository);

        ControllerPedido controller = new ControllerPedido(fazerPedidoUseCase, listarPedidosUC);
        controller.iniciar();
    }


}
