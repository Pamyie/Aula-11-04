package domain.entities;

public class Produto {
    private String nomeproduto;
    private double valor;
    private int estoque;

    public Produto(String nome, double valor, int estoque){
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do produto é obrigatório.");
        }
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor do produto deve ser maior que zero.");
        }
        if (estoque < 0){
            throw new IllegalArgumentException("Estoque do produto não pode ser negativo.");
        }
        this.nomeproduto = nome;
        this.valor = valor;
        this.estoque = estoque;
    }
    public String getNomeproduto() {return nomeproduto;}

    public double getValor() {return valor;}

    public int getEstoque(){ return estoque;}

    public boolean temEstoque() { return estoque > 0;}

    public void baixaEstoque(){
        if (!temEstoque()){
            throw new IllegalStateException("Produto zerado.");
        }
        estoque --;
    }


}



