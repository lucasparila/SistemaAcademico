package br.ifsp.lucasparila.model;

public class Frequencia {
    private int aulasDadas;
    private int faltas;

    public Frequencia() {
        this.aulasDadas = 0;
        this.faltas = 0;
    }

    public int getAulasDadas() {
        return aulasDadas;
    }

    public int getFaltas() {
        return faltas;
    }

    /**
     * Adiciona novas aulas dadas, garantindo que o valor não seja negativo.
     */
    public void adicionarAulas(int quantidade) {
        if (quantidade > 0) {
            this.aulasDadas += quantidade;
        } 
    }

    /**
     * Registra faltas, garantindo que não ultrapassem o número de aulas dadas.
     */
    public void registrarFaltas(int quantidade) {
        if (quantidade < 0) {     
            return;
        }
        if (faltas + quantidade > aulasDadas) {
          
            return;
        }
        this.faltas += quantidade;
    }

    public void setAulasDadas(int aulasDadas) {
		this.aulasDadas = aulasDadas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	/**
     * Retorna a frequência do aluno como uma porcentagem.
     */
    public double calcularFrequencia() {
        if (aulasDadas == 0) {
            return 100.0; // Se não houver aulas, a frequência é 100%.
        }
        return ((double) (aulasDadas - faltas) / aulasDadas) * 100;
    }
}

