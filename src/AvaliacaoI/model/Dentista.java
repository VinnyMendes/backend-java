package AvaliacaoI.model;

public class Dentista {

    private final String matricula;
    private final String nome;
    private final String sobrenome;

    public Dentista(String matricula, String nome, String sobrenome) {
        this.matricula = matricula;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getMatricula() {
        return matricula;
    }
    public String getNome() {
        return nome;
    }
    public String getSobrenome() {
        return sobrenome;
    }
}
