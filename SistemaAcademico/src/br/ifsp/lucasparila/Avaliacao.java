package br.ifsp.lucasparila;

public class Avaliacao {
    private String nome;
    private double peso;
    private double nota;

    // Construtor
    public Avaliacao(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
        this.nota = 0; // Inicia com nota 0
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    // Método para calcular a nota parcial (peso * nota)
    public double calcularNotaParcial() {
        return peso * nota;
    }
}
