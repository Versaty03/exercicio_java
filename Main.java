import java.time.LocalDate;
import java.time.Period;

class Pessoa {
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;

    public Pessoa(String nome, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CPF: " + cpf + ", Data de Nascimento: " + dataNascimento;
    }
}

class Cliente extends Pessoa {
    private int id;

    public Cliente(String nome, String cpf, LocalDate dataNascimento, int id) {
        super(nome, cpf, dataNascimento);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.toString() + ", ID: " + id;
    }
}

public class Main {
    public static void main(String[] args) {
        Cliente[] clientes = new Cliente[3];

        clientes[0] = new Cliente("João", "111.111.111-11", LocalDate.of(1990, 3, 15), 1);
        clientes[1] = new Cliente("Maria", "222.222.222-22", LocalDate.of(1985, 7, 10), 2);
        clientes[2] = new Cliente("José", "333.333.333-33", LocalDate.of(1978, 5, 23), 3);

        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }

        System.out.println("\nClientes com idade maior ou igual a 30 anos:");

        for (Cliente cliente : clientes) {
            if (cliente.getIdade() >= 30) {
                System.out.println(cliente.toString());
            }
        }
    }
}
