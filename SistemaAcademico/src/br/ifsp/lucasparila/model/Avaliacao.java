package br.ifsp.lucasparila.model;


/**
* Representa uma avaliação em um sistema acadêmico, com informações sobre o nome da avaliação, 
* o peso atribuído e a nota do aluno.
*/
public class Avaliacao {
    private String nome;
    private double peso;
    private double nota;

    /**
     * Construtor da avaliação.
     * 
     * @param nome O nome da avaliação.
     * @param peso O peso da avaliação.
     */
    public Avaliacao(String nome, double peso) {
        this.nome = nome;
        this.peso = peso;
        this.nota = 0; // Inicia com nota 0
    }

    
    /**
     * Retorna o nome da avaliação.
     * 
     * @return O nome da avaliação.
     */
    public String getNome() {
        return nome;
    }

    
    /**
     * Define o nome da avaliação.
     * 
     * @param nome O nome a ser atribuído à avaliação.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    /**
     * Retorna o peso da avaliação.
     * 
     * @return O peso da avaliação.
     */
    public double getPeso() {
        return peso;
    }

    
    /**
     * Define o peso da avaliação.
     * 
     * @param peso O peso a ser atribuído à avaliação.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    
    /**
     * Retorna a nota da avaliação.
     * 
     * @return A nota da avaliação.
     */
    public double getNota() {
        return nota;
    }
    
    
    
    /**
     * Define a nota da avaliação.
     * 
     * @param nota A nota a ser atribuída à avaliação.
     */
    public void setNota(double nota) {
        this.nota = nota;
    }

    /**
     * Calcula a nota parcial de acordo com o peso e a nota da avaliação.
     * 
     * @return O valor da nota parcial (peso * nota).
     */
    public double calcularNotaParcial() {
        return peso * nota;
    }
}
