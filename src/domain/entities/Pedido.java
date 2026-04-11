package domain.entities;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
  private int numeropedido;
  private Cliente cliente;
  private List<Produto> produtos;
  private String statuspedido;
  private double total;

  public Pedido(int numeropedido, Cliente cliente){
      if (cliente == null) {
          throw new IllegalArgumentException("Cliente é obrigatório");

      }
      this.numeropedido = numeropedido;
      this.cliente = cliente;
      this.produtos = new ArrayList<Produto>();
      this.statuspedido = "Aberto";
      this.total = 0.0;
  }


}
