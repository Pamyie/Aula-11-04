package domain.entities;

public class Cliente {
    private String nome;
    private String cpf;


    public Cliente(String nome, String cpf){

        if (nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome do clinente é obrigatório.");
        }
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new IllegalArgumentException("CPF do cliente é obrigatório.");
        }
        this.nome = nome;
        this.cpf = cpf;

    }
    public String getNome() {
        return nome;
    }

    public String getCpf(){
        return cpf;
    }

}
