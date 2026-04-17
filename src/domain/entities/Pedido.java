package domain.entities;

import java.util.ArrayList;
import java.util.Collections;
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
  public void addProduto(Produto produto){
      if (produto == null){
          throw new IllegalArgumentException("Produto é obrigatório");
      }
      if (!produto.temEstoque()){
          throw new IllegalStateException("Produto zerado");
      }
      produtos.add(produto);
      total += produto.getValor();
      produto.baixaEstoque();

  }

  public void fecharPedido(){
      if (produtos.isEmpty()){
          throw new IllegalStateException("Adicione ao menos um produto");
      }
      if (total > 500){
          total *= 0.9;
      }
      statuspedido = "Fechado";
  }

  public void cancelar(){
      if (statuspedido.equals("Cancelado")){
          throw new IllegalArgumentException("Pedido já cancelado");
      }
      statuspedido = "Cancelado";
  }

  public int getNumeropedido(){ return numeropedido; }

  public Cliente getCliente(){ return cliente;}

  public List<Produto> getProdutos(){ return Collections.unmodifiableList(produtos); }

  public String getStatuspedido(){ return statuspedido;}

  public double getTotal(){ return total; }

}
