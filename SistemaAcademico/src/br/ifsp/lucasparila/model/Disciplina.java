package br.ifsp.lucasparila.model;


/**
 * Classe que representa uma disciplina no sistema.
 * A classe contém informações sobre o nome, sigla, emenda, carga horária e total de aulas de uma disciplina.
 */
public class Disciplina {
    private String nome;
    private String sigla;
    private String emenda;
    private int cargaHoraria;
    private int totalAulas;

    /**
     * Construtor para criar uma nova disciplina.
     *
     * @param nome        Nome da disciplina.
     * @param sigla       Sigla da disciplina.
     * @param emenda      Emenda curricular da disciplina.
     * @param cargaHoraria Carga horária total da disciplina em horas.
     * @param totalAulas  Total de aulas previstas para a disciplina.
     */
    public Disciplina(String nome, String sigla, String emenda, int cargaHoraria, int totalAulas) {
        this.nome = nome;
        this.sigla = sigla;
        this.emenda = emenda;
        this.cargaHoraria = cargaHoraria;
        this.totalAulas = totalAulas;
    }

    /**
     * Retorna o nome da disciplina.
     *
     * @return O nome da disciplina.
     */
    public String getNome() {
        return nome;
    }

    
    /**
     * Define o nome da disciplina.
     *
     * @param nome O nome a ser definido para a disciplina.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    /**
     * Retorna a sigla da disciplina.
     *
     * @return A sigla da disciplina.
     */
    public String getSigla() {
        return sigla;
    }

    
    /**
     * Define a sigla da disciplina.
     *
     * @param sigla A sigla a ser definida para a disciplina.
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    
    /**
     * Retorna a emenda curricular da disciplina.
     *
     * @return A emenda curricular da disciplina.
     */
    public String getEmenda() {
        return emenda;
    }

    
    /**
     * Define a emenda curricular da disciplina.
     *
     * @param emenda A emenda a ser definida para a disciplina.
     */
    public void setEmenda(String emenda) {
        this.emenda = emenda;
    }

    
    /**
     * Retorna a carga horária da disciplina.
     *
     * @return A carga horária da disciplina em horas.
     */
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    
    /**
    * Define a carga horária da disciplina.
    *
    * @param cargaHoraria A carga horária a ser definida para a disciplina.
    */
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    
    /**
     * Retorna o total de aulas previstas para a disciplina.
     *
     * @return O total de aulas da disciplina.
     */
    public int getTotalAulas() {
        return totalAulas;
    }

    
    /**
     * Define o total de aulas previstas para a disciplina.
     *
     * @param totalAulas O total de aulas a ser definido para a disciplina.
     */
    public void setTotalAulas(int totalAulas) {
        this.totalAulas = totalAulas;
    }

    
    /**
     * Visualiza as informações da disciplina em formato de string.
     * 
     * @return Uma string contendo todas as informações da disciplina.
     */
    public String visualizarInformacoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome da Disciplina: ").append(nome).append("\n");
        sb.append("Sigla: ").append(sigla).append("\n");
        sb.append("Emenda: ").append(emenda).append("\n");
        sb.append("Carga Horária: ").append(cargaHoraria).append(" horas\n");
        sb.append("Total de Aulas: ").append(totalAulas).append("\n");
        
        return sb.toString();
    }
        
        
}

