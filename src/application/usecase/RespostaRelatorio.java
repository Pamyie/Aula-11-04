package application.usecase;

public class RespostaRelatorio {

    private final int totalPedidos;
    private final int cancelados;
    private final double receitaTotal;
    private final double receitaTotalCancelada;



    public RespostaRelatorio(int totalPedidos, int cancelados, double receitaTotal, double receitaTotalCancelada){
        this.totalPedidos = totalPedidos;
        this.cancelados = cancelados;
        this.receitaTotal = receitaTotal;
        this.receitaTotalCancelada = receitaTotalCancelada;
    }

    public int getTotalPedidos(){
        return totalPedidos;
    }

    public int getCancelados(){
        return cancelados;
    }

    public double getReceitaTotal(){
        return receitaTotal;
    }

    public double getReceitaTotalCancelada(){
        return receitaTotalCancelada;
    }

}
