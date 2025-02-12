package br.ifsp.lucasparila.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma turma em um sistema acadêmico, com informações sobre o código da turma, 
 * professor responsável, disciplina ministrada, avaliações e matrículas dos alunos.
 */
public class Turma {
    private String codigo;
    private Professor professor;
    private Disciplina disciplina;
    private List<Avaliacao> avaliacoes;
    private List<Matricula> matriculas;
    

    /**
     * Construtor da turma.
     * 
     * @param codigo Código único da turma.
     * @param professor Professor responsável pela turma.
     * @param disciplina Disciplina ministrada na turma.
     */
    public Turma(String codigo, Professor professor, Disciplina disciplina) {
        this.codigo = codigo;
        this.professor = professor;
        this.disciplina = disciplina;
        matriculas = new ArrayList<>();
        avaliacoes = new ArrayList<>();
    }

    
    /**
     * Retorna o código da turma.
     * 
     * @return O código da turma.
     */
    public String getCodigo() {
        return codigo;
    }
    
    
    /**
     * Define o código da turma.
     * 
     * @param codigo O código a ser atribuído à turma.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    /**
     * Retorna o professor responsável pela turma.
     * 
     * @return O professor da turma.
     */
    public Professor getProfessor() {
        return professor;
    }
    
    
    /**
     * Define o professor responsável pela turma.
     * 
     * @param professor O professor a ser atribuído à turma.
     */
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    
    
    /**
     * Retorna a disciplina ministrada na turma.
     * 
     * @return A disciplina da turma.
     */
    public Disciplina getDisciplina() {
        return disciplina;
    }
    
    
    /**
     * Define a disciplina ministrada na turma.
     * 
     * @param disciplina A disciplina a ser atribuída à turma.
     */
    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    
    /**
     * Retorna a lista de avaliações associadas à turma.
     * 
     * @return A lista de avaliações.
     */
    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
    
    
    /**
     * Define uma avaliação para a turma.
     * 
     * @param avaliacao A avaliação a ser associada.
     * @param nomeAvaliacao O nome da avaliação.
     * @param peso O peso da avaliação.
     */
    public void setAvaliacao(Avaliacao avaliacao, String nomeAvaliacao, double peso) {
    	avaliacao.setNome(nomeAvaliacao);
    	avaliacao.setPeso(peso);
    }
    
    
    
    /**
     * Define a avaliação para todas as matrículas associadas à turma.
     * 
     * @param avaliacao A avaliação a ser atribuída.
     * @param nomeAvaliacao O nome da avaliação.
     * @param peso O peso da avaliação.
     */
    public void setAvaliacaoMatriculas(Avaliacao avaliacao, String nomeAvaliacao, double peso) {
    	
    	for(Matricula m : matriculas) {
    		m.setAvaliacoes(avaliacao, nomeAvaliacao, peso);
    	}
    }

    
    /**
     * Adiciona uma avaliação à turma.
     * 
     * @param avaliacao A avaliação a ser adicionada.
     */
    public void adicionarAvaliacao(Avaliacao avaliacao) {
       avaliacoes.add(avaliacao);
    }
    
    
    /**
     * Remove uma avaliação da turma.
     * 
     * @param avaliacao A avaliação a ser removida.
     */
    public void removerAvaliacao(Avaliacao avaliacao) {
    	avaliacoes.remove(avaliacao);
    }
    
    
    /**
     * Remove uma avaliação de todas as matrículas associadas à turma.
     * 
     * @param avaliacao A avaliação a ser removida.
     */
    public void removerAvaliacaoMatriculas(Avaliacao avaliacao) {
    	for(Matricula m : matriculas) {
    		m.removerAvaliacao(avaliacao);
    	}
    }
    
    
    /**
     * Busca uma matrícula de aluno na turma por seu prontuário.
     * 
     * @param prontuarioAluno O prontuário do aluno.
     * @return A matrícula do aluno na turma, ou null se não encontrado.
     */
    public Matricula buscarMatriculaPorProntuarioAluno (String prontuarioAluno) {
    	for(Matricula a : matriculas) {
    		if(a.getAluno().getProntuario().equals(prontuarioAluno)) {
    			return a;
    		}
    		
    	}
    	
    	return null;
    }
    
    
    /**
     * Verifica se a turma possui avaliações cadastradas.
     * 
     * @return true se não houver avaliações, caso contrário false.
     */
    public boolean turmaAvaliacoesVazia() {
    	return avaliacoes.isEmpty();
    }
    
    
    /**
     * Adiciona uma avaliação a todas as matrículas da turma.
     * 
     * @param avaliacao A avaliação a ser adicionada.
     */
    public void adicionarAvaliacaoMatriculas(Avaliacao avaliacao) {
        for(Matricula m : matriculas) {
            Avaliacao novaAvaliacao = new Avaliacao(avaliacao.getNome(), avaliacao.getPeso());
            m.adicionarAvaliacao(novaAvaliacao);
        }
    }

    
    
    /**
     * Adiciona todas as avaliações da turma a todas as matrículas da turma.
     */
    public void adicionarAvaliacoesMatriculas() {
    	
    	for(Avaliacao a : avaliacoes) {
    		for(Matricula m : matriculas) {
    			Avaliacao novaAvaliacao = new Avaliacao(a.getNome(), a.getPeso());
    			m.adicionarAvaliacao(novaAvaliacao);
    		}
    	}
    }
    
    
    
    /**
     * Busca uma avaliação pela sua nomenclatura.
     * 
     * @param nome O nome da avaliação.
     * @return A avaliação com o nome especificado, ou null se não encontrada.
     */
    public Avaliacao buscarAvaliacaoPorNome(String nome) {
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getNome().equals(nome)) {
                return avaliacao;
            }
        }
        return null; // Retorna null se não encontrar
    }
    
    
    /**
    * Define a nota de um aluno para uma avaliação específica.
    * 
    * @param matricula A matrícula do aluno.
    * @param avaliacao A avaliação à qual a nota será atribuída.
    * @param nota A nota do aluno.
    */
    public void setNotaPorMatricula(Matricula matricula, Avaliacao avaliacao, double nota) {
    	matricula.setNotaAvaliacao(avaliacao, nota);
    }
    
    
    
    /**
     * Exibe informações gerais sobre a turma.
     * 
     * @return Uma string contendo o código da turma, o nome do professor e o nome da disciplina.
     */
    public String visualizarInformacoes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código da Turma: ").append(codigo).append("\n");
        if(this.professor == null) {
        	sb.append("Professor Responsável: ").append(" - ").append("\n");
        }else {
        	sb.append("Professor Responsável: ").append(professor.getNome()).append("\n");
        }
        
        sb.append("Disciplina: ").append(disciplina.getNome()).append("\n");
        return sb.toString();
    }
    
    
    /**
     * Exibe as avaliações cadastradas para a turma.
     * 
     * @return Uma string contendo informações sobre todas as avaliações da turma.
     */
    public String exibirAvaliacoes() {
        StringBuilder sb = new StringBuilder();
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
        return sb.toString();
   }
    
    
    /**
     * Adiciona uma matrícula de aluno à turma.
     * 
     * @param matricula A matrícula do aluno a ser adicionada.
     */
    public void adicionarMatricula(Matricula matricula) {
    	this.matriculas.add(matricula);
    }
    
    
    /**
     * Remove uma matrícula de aluno da turma.
     * 
     * @param matricula A matrícula do aluno a ser removida.
     */
    public void removerMatricula(Matricula matricula) {
    	matriculas.remove(matricula);
    }
    
    
    /**
     * Retorna a lista de matrículas associadas à turma.
     * 
     * @return A lista de matrículas da turma.
     */
    public List<Matricula> getMatriculas(){
    	return matriculas;
    }
    
    
    /**
     * Exibe as matrículas dos alunos na turma.
     * 
     * @return Uma string contendo os nomes dos alunos matriculados na turma.
     */
    public String exibirMatriculas() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.visualizarInformacoes());
        if (!matriculas.isEmpty()) {
            sb.append("Matriculas:\n");
            for (Matricula matricula : matriculas) {
                sb.append("- ").append(matricula.getAluno().getNome()).append("\n");
            }
        } else {
            sb.append("Nenhum aluno matriculado ainda.\n");
        }
        return sb.toString();
    }

}

