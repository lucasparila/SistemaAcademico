package br.ifsp.lucasparila;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private String sigla;
    private String emenda;
    private int cargaHoraria;
    private int totalAulas;
    private List<Avaliacao> avaliacoes;

    // Construtor
    public Disciplina(String nome, String sigla, String emenda, int cargaHoraria, int totalAulas) {
        this.nome = nome;
        this.sigla = sigla;
        this.emenda = emenda;
        this.cargaHoraria = cargaHoraria;
        this.totalAulas = totalAulas;
        this.avaliacoes = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getEmenda() {
        return emenda;
    }

    public void setEmenda(String emenda) {
        this.emenda = emenda;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getTotalAulas() {
        return totalAulas;
    }

    public void setTotalAulas(int totalAulas) {
        this.totalAulas = totalAulas;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    // Método para adicionar avaliação
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        this.avaliacoes.add(avaliacao);
    }
    
    public String visualizarInformacoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome da Disciplina: ").append(nome).append("\n");
        sb.append("Sigla: ").append(sigla).append("\n");
        sb.append("Emenda: ").append(emenda).append("\n");
        sb.append("Carga Horária: ").append(cargaHoraria).append(" horas\n");
        sb.append("Total de Aulas: ").append(totalAulas).append("\n");
        
        // Exibir avaliações, se existirem
        if (avaliacoes != null && !avaliacoes.isEmpty()) {
            sb.append("Avaliações:\n");
            for (Avaliacao avaliacao : avaliacoes) {
                sb.append(" - ").append(avaliacao.getNome())
                  .append(" (Peso: ").append(avaliacao.getPeso())
                  .append(", Nota: ").append(avaliacao.getNota())
                  .append(", Nota Parcial: ").append(avaliacao.calcularNotaParcial()).append(")\n");
            }
        } else {
            sb.append("Nenhuma avaliação cadastrada.\n");
        }

        // Exibir as informações
        return sb.toString();
    }
}

