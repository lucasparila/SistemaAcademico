package br.ifsp.lucasparila.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Representa uma matrícula de um aluno em uma turma, incluindo informações sobre avaliações,
 * frequência, notas e a situação do aluno.
 */
public class Matricula {
	
	private List<Avaliacao> avaliacoes;
	private Frequencia frequencia;
    private Aluno aluno;
    private Turma turma;

    
    /**
     * Constrói uma nova matrícula associando um aluno e uma turma.
     *
     * @param aluno O aluno associado à matrícula.
     * @param turma A turma na qual o aluno está matriculado.
     */
    public Matricula(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
        avaliacoes = new ArrayList<>();
        this.frequencia=new Frequencia();
    }

    /**
     * Retorna o aluno associado à matrícula.
     *
     * @return O aluno associado à matrícula.
     */
    public Aluno getAluno() {
        return aluno;
    }
    
    
    /**
     * Define o aluno associado à matrícula.
     *
     * @param aluno O aluno a ser associado à matrícula.
     */
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
    /**
     * Retorna a turma associada à matrícula.
     *
     * @return A turma associada à matrícula.
     */
    public Turma getTurma() {
        return turma;
    }

    
    /**
     * Retorna a lista de avaliações do aluno.
     *
     * @return A lista de avaliações do aluno.
     */
    public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}
    
    
    /**
     * Busca uma avaliação pelo nome na lista de avaliações do aluno.
     *
     * @param avaliacaoNome O nome da avaliação a ser buscada.
     * @return A avaliação encontrada, ou null se não houver uma avaliação com esse nome.
     */
    public Avaliacao buscarAvaliacao(String avaliacaoNome) {
    	
    	for(Avaliacao a : avaliacoes) {
    		if(a.getNome().equals(avaliacaoNome)){
    			
    			return a;
    		}
    	}
    	
    	return null;
    }
    
    
    
    /**
     * Atualiza o nome e o peso de uma avaliação existente na lista de avaliações do aluno.
     *
     * @param avaliacao A avaliação a ser atualizada.
     * @param nomeAvaliacao O novo nome da avaliação.
     * @param peso O novo peso da avaliação.
     */
    public void setAvaliacoes(Avaliacao avaliacao, String nomeAvaliacao, double peso) {
    	for(Avaliacao a : avaliacoes) {
    		if(a.getNome().equalsIgnoreCase(avaliacao.getNome()) && a.getPeso() == avaliacao.getPeso()) {
    			a.setNome(nomeAvaliacao);
    			a.setPeso(peso);
    		}
    	}
    }
    
    
    /**
     * Define a lista de avaliações do aluno.
     *
     * @param avaliacoes A lista de avaliações a ser atribuída ao aluno.
     */
	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
	public void setNotaAvaliacao(Avaliacao avaliacao, double nota) {
		avaliacao.setNota(nota);
	}
	
	
	/**
     * Define a turma associada à matrícula.
     *
     * @param turma A turma a ser associada à matrícula.
     */
	public void setTurma(Turma turma) {
        this.turma = turma;
    }

	/**
     * Visualiza a matrícula do aluno, exibindo as avaliações, as notas finais, a frequência
     * e a situação do aluno.
     *
     * @return Uma string contendo as informações detalhadas da matrícula.
     */
    public String visualizarMatricula() {
        StringBuilder sb = new StringBuilder();
        sb.append("Aluno: ").append(aluno.getNome()).append("\n");
        sb.append("Matriculado na turma: ").append(turma.getCodigo()).append("\n");
        sb.append("Disciplina: ").append(turma.getDisciplina().getNome()).append("\n");
        sb.append("Avaliações:\n");

        if (avaliacoes.isEmpty()) {
            sb.append("Nenhuma avaliação cadastrada para o aluno.\n");
        } else {
            for (Avaliacao avaliacao : avaliacoes) {
                sb.append("- ").append(avaliacao.getNome())
                  .append(" (Peso: ").append(avaliacao.getPeso())
                  .append(", Nota: ").append(avaliacao.getNota()).append(")\n");
            }
            
            sb.append(" Nota final: ").append(calcularMediaMatricula()).append("\n");
            
        }
        
        sb.append("Total Aulas Dadas: ").append(this.frequencia.getAulasDadas()).append("\n");
        sb.append("Total de Faltas: ").append(this.frequencia.getFaltas()).append("\n");
        sb.append("Percentual Frequencia: ").append(percentualFrequencia()).append("\n");
        sb.append("Situação: ").append(situacaoMatricula()).append("\n");

        sb.append("----------------------------\n");

        return sb.toString();
    }

    
    /**
     * Adiciona uma avaliação à lista de avaliações do aluno, se não houver outra avaliação com
     * o mesmo nome e peso.
     *
     * @param avaliacao A avaliação a ser adicionada.
     */
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        // Verifica se já existe uma avaliação com o mesmo nome e peso
        for (Avaliacao a : avaliacoes) {
            if (a.getNome().equalsIgnoreCase(avaliacao.getNome()) && a.getPeso() == avaliacao.getPeso()) {
                return; // Sai do método sem adicionar
            }
        }

        // Se não existir, adiciona a nova avaliação
        avaliacoes.add(avaliacao);        
    }

    
    /**
     * Calcula a média ponderada das notas do aluno, levando em consideração os pesos das avaliações.
     *
     * @return A média ponderada das notas.
     */
    double calcularMediaMatricula() {
    	double media = 0.0;
    	int somaPesos = 0;
    	for(Avaliacao a : avaliacoes) {
    		media += a.calcularNotaParcial();
    		somaPesos += a.getPeso();
    	}
    	
    	return media / somaPesos;
    }
    
    
    /**
     * Remove uma avaliação específica da lista de avaliações do aluno.
     *
     * @param avaliacao A avaliação a ser removida.
     */
    public void removerAvaliacao(Avaliacao avaliacao) {
    	
    	  for (Avaliacao a : avaliacoes) {
              if (a.getNome().equalsIgnoreCase(avaliacao.getNome()) && a.getPeso() == avaliacao.getPeso()) {
            	  avaliacoes.remove(avaliacao);
              }
    	  }
    }

    
    /**
     * Retorna a frequência do aluno na matrícula.
     *
     * @return O objeto de frequência associado à matrícula.
     */
	public Frequencia getFrequencia() {
		return frequencia;
	}

	
	/**
     * Define as informações de frequência (aulas dadas e faltas) para o aluno.
     *
     * @param frequencia O objeto de frequência.
     * @param aulasDadas O número de aulas dadas.
     * @param faltas O número de faltas do aluno.
     */
	public void setFrequencia(Frequencia frequencia, int aulasDadas, int faltas) {
		this.frequencia.setAulasDadas(aulasDadas);
		this.frequencia.setFaltas(faltas);
	}
	
	
	/**
     * Calcula o percentual de frequência do aluno, baseado no total de aulas dadas e o número de faltas.
     *
     * @return O percentual de frequência do aluno.
     */
	public double percentualFrequencia() {
		if(this.frequencia.getAulasDadas() == 0) {
			return 0.0;
		}
		
		return this.frequencia.calcularFrequencia();
	}
	
	
	 /**
     * Retorna o percentual de frequência do aluno.
     *
     * @return O percentual de frequência.
     */
	public double getPercentualFrequencia() {
        return this.frequencia.calcularFrequencia();
    }
	
	
	/**
     * Determina a situação da matrícula do aluno, levando em consideração a frequência e a média das
     * avaliações.
     *
     * @return A situação da matrícula, que pode ser "Cursando", "Aprovado", "IFA" ou "Reprovado".
     */
	public String situacaoMatricula() {
		String situacao;
		
		if(this.frequencia.getAulasDadas() < this.turma.getDisciplina().getTotalAulas()) {
			situacao = "Cursando.";
					
		}else if(this.frequencia.getAulasDadas() == this.turma.getDisciplina().getTotalAulas() && calcularMediaMatricula() >= 6.0 && percentualFrequencia()> 75.0) {
			situacao = "Aprovado";
		}else if(this.frequencia.getAulasDadas() == this.turma.getDisciplina().getTotalAulas() && calcularMediaMatricula() > 4.0 && calcularMediaMatricula() < 6.0 && percentualFrequencia()> 75.0 ) {
			situacao = "IFA";
		}else {
			situacao = "Reprovado";
		}
		
		return situacao;
		
	}

}
