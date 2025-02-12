package br.ifsp.lucasparila.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe que representa um professor no sistema.
 * A classe permite ao professor adicionar avaliações, visualizar matrículas e gerenciar turmas.
 */
public class Professor extends Usuario {
	List<Turma> turmas = new ArrayList<>();
	
	
	 /**
     * Construtor para criar um novo professor.
     *
     * @param username      Nome de usuário do professor.
     * @param senha         Senha do professor.
     * @param prontuario    Prontuário do professor.
     * @param nome          Nome completo do professor.
     * @param dataNascimento Data de nascimento do professor.
     */
    public Professor(String username, String senha, String prontuario, String nome, String dataNascimento) {
        super(username, senha, prontuario, nome, dataNascimento);
    }

    /**
     * Adiciona uma nova avaliação a uma turma específica.
     *
     * @param turma          A turma à qual a avaliação será adicionada.
     * @param nomeAvaliacao O nome da avaliação.
     * @param peso          O peso da avaliação.
     */
    public void adicionarAvaliacao(Turma turma, String nomeAvaliacao, double peso) {
        Avaliacao avaliacao = new Avaliacao(nomeAvaliacao, peso);
        turma.adicionarAvaliacao(avaliacao);
        System.out.println("Avaliação '" + nomeAvaliacao + "' adicionada à turma " + turma.getCodigo());
    }
    
    
    /**
     * Valida o login do professor verificando a senha.
     *
     * @param senha A senha fornecida pelo professor.
     * @return true se a senha for válida, false caso contrário.
     */
    @Override
    public boolean validarLogin(String senha) {
    	return super.getSenha().equals(senha);
    }
    
    
    /**
     * Visualiza as matrículas dos alunos em todas as turmas do professor.
     *
     * @return Uma string com as informações das matrículas dos alunos.
     */
    public String visualizarMatriculas() {
    	StringBuilder sb = new StringBuilder();
    	
    	for(Turma t : turmas) {
    		sb.append(t.exibirMatriculas());
    	}
    	
    	return sb.toString();
    }
    
    
    /**
     * Adiciona uma turma à lista de turmas do professor.
     *
     * @param turma A turma a ser adicionada.
     */
    public void adicionarProfessor(Turma turma) {
    	turmas.add(turma);
    }
    
    
    /**
     * Retira o professor de todas as suas turmas.
     */
    public void retirarProfessorTurmas() {
    	
    	for(Turma t : turmas) {
    		t.setProfessor(null);
    	}
    }
    
    
    /**
     * Retorna a lista de turmas em que o professor está inserido.
     *
     * @return A lista de turmas do professor.
     */
    public List<Turma> getTurmas() {
        return turmas;
    }
    
 
    
    /**
     * Busca uma turma específica pelo código.
     *
     * @param codigo O código da turma a ser buscada.
     * @return A turma com o código fornecido, ou null se não encontrada.
     */
    public Turma buscarTurmaPorCodigo(String codigo) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigo)) {
                return turma;
            }
        }
        return null; // Retorna null se não encontrar
    }
    
    
    /**
     * Visualiza as turmas disponíveis para o professor.
     *
     * @return Uma string com as informações das turmas disponíveis.
     */
    public String visualizarTurmasDisponiveis(){
    	
    	StringBuilder sb= new StringBuilder();
        if (turmas.isEmpty()) {
            sb.append("Nenhuma turma disponível.");
        } else {
            sb.append("Turmas Disponíveis:");
            for (Turma turma : turmas) {
                sb.append(turma.visualizarInformacoes());
                
            }
        }
        
        return sb.toString();
    	
    }
}
