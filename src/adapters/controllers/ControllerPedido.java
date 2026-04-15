package adapters.controllers;


import application.dto.FazerPedido;
import application.usecase.FazerPedidoUseCase;
import application.usecase.ListarPedidosUC;
import domain.entities.Pedido;
import domain.entities.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControllerPedido {

    private FazerPedidoUseCase fazerPedidoUseCase;
    private ListarPedidosUC listarPedidosUC;
    private Scanner scanner = new Scanner(System.in);

    public ControllerPedido(FazerPedidoUseCase fazerPedidoUseCase, ListarPedidosUC listarPedidosUC){
        this.fazerPedidoUseCase = fazerPedidoUseCase;
        this.listarPedidosUC = listarPedidosUC;
    }

    public void iniciar(){
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE PEDIDOS =====");
            System.out.println("1 - Fazer pedido");
            System.out.println("2 - Listar pedidos");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    fazerPedido();
                    break;
                case 2:
                    listarPedidos();
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }
    private void fazerPedido(){
        try{
            System.out.print ("Nome do Cliente: ");
            String nomeCliente = scanner.nextLine();

            System.out.print("CPF do cliente: ");
            String cpfCliente = scanner.nextLine();

            List<String> nomes = new ArrayList<String>();
            List<Double> precos = new ArrayList<Double>();
            List<Integer> estoques = new ArrayList<Integer>();

            String continuar;
            do {
                System.out.print("Nome do produto: ");
                nomes.add(scanner.nextLine());

                System.out.print("Preço do produto: ");
                precos.add(Double.parseDouble(scanner.nextLine()));

                System.out.print("Estoque disponível para o produto: ");
                estoques.add(Integer.parseInt(scanner.nextLine()));

                System.out.print("Deseja adicionar outro produto? (s/n): ");
                continuar = scanner.nextLine();
            } while (continuar.equalsIgnoreCase("s"));

            FazerPedido request = new FazerPedido(nomeCliente, cpfCliente, nomes, precos, estoques);
            Pedido pedido = fazerPedidoUseCase.execute(request);

            System.out.println("\nPedido criado com sucesso.");
            System.out.println("Número: " + pedido.getNumeropedido());
            System.out.println("Cliente: " + pedido.getCliente().getNome());
            System.out.println("Status: " + pedido.getStatuspedido());
            System.out.println("Valor total: R$ " + pedido.getTotal());

        }catch (Exception e){
            System.out.println("Erro ao criar pedido: " + e.getMessage());
        }

    }

    private void listarPedidos(){
        List<Pedido> pedidos = listarPedidosUC.execute();

        if (pedidos.isEmpty()){
            System.out.println("Nenhum pedido encontrado.");
            return;
        }

        System.out.println("\n===== LISTA DE PEDIDOS =====");
        for (Pedido pedido : pedidos){
            System.out.println("Número: " + pedido.getNumeropedido());
            System.out.println("Cliente: " + pedido.getCliente().getNome());
            System.out.println("CPF: " + pedido.getCliente().getCpf());
            System.out.println("Status: " + pedido.getStatuspedido());
            System.out.println("Produtos: ");
            for (Produto produto : pedido.getProdutos()){
                System.out.println("- " + produto.getNomeproduto() + " | Preço: R$ " + produto.getValor());
            }
            System.out.println("Valor total: R$ " + pedido.getTotal());
        }
    }
}
