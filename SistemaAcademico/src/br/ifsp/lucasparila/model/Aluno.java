package br.ifsp.lucasparila.model;

import java.util.ArrayList;


/**
 * Classe que representa um aluno no sistema.
 * A classe herda de {@link Usuario} e possui métodos para gerenciar suas matrículas, visualizações e validações.
 */
public class Aluno extends Usuario {
    private ArrayList<Matricula> matriculas = new ArrayList<>();

    /**
     * Construtor para criar um novo aluno.
     *
     * @param username        Nome de usuário para login.
     * @param senha          Senha do aluno.
     * @param prontuario     Número de identificação do aluno.
     * @param nome           Nome completo do aluno.
     * @param dataNascimento Data de nascimento do aluno.
     */
    public Aluno(String username, String senha, String prontuario, String nome, String dataNascimento) {
        super(username, senha, prontuario, nome, dataNascimento);
    }

    /**
     * Valida o login do aluno comparando a senha fornecida com a senha armazenada.
     *
     * @param senha A senha fornecida para validação.
     * @return {@code true} se a senha fornecida for igual à senha armazenada, caso contrário, {@code false}.
     */
    @Override
    public boolean validarLogin(String senha) {
    	return super.getSenha().equals(senha);
    }
    

    /**
     * Visualiza as matrículas do aluno.
     * Exibe todas as informações das matrículas, incluindo avaliações e frequência.
     *
     * @return Uma string representando as matrículas do aluno.
     */
    public String visualizarMatriculas() {
    	StringBuilder sb= new StringBuilder();
        if (getMatriculas().isEmpty()) {
            sb.append("Nenhuma matrícula realizada.");
        } else {
            sb.append("Matrículas do Aluno:");
            for (Matricula matricula : getMatriculas()) {
                sb.append(matricula.visualizarMatricula());
            }
        }
        
        return sb.toString();
    }
    
    /**
     * Visualiza as turmas em que o aluno está matriculado.
     * Exibe todas as informações das turmas nas quais o aluno está registrado.
     *
     * @return Uma string representando as turmas em que o aluno está matriculado.
     */
    public String visualizarTurmasDisponiveis() {
    	StringBuilder sb= new StringBuilder();
        if (getMatriculas().isEmpty()) {
            sb.append(super.getNome() + " não está matriculado em nenhuma turma.");
        } else {
            sb.append("Turmas nas quais " + super.getNome() + " está matriculado:");
            for (Matricula matricula : getMatriculas()) {
               sb.append(matricula.getTurma().visualizarInformacoes());
                sb.append("-------------------");
            }
        }
        
        return sb.toString();
    }
    
    
    /**
     * Busca uma turma através de seu código.
     *
     * @param codigo O código da turma a ser buscada.
     * @return A turma correspondente ao código informado ou {@code null} caso não encontre.
     */
    public Turma buscarTurmaPorCodigo(String codigo) {
    	
    	for(Matricula m : matriculas) {
    		if(m.getTurma().getCodigo().equals(codigo)) {
    			return m.getTurma();
    		}
    	}
    	
    	return null;
    }

    /**
     * Recupera a lista de matrículas do aluno.
     *
     * @return A lista de matrículas.
     */
	public ArrayList<Matricula> getMatriculas() {
		return matriculas;
	}

	/**
     * Define as matrículas do aluno.
     *
     * @param matriculas A lista de matrículas a ser associada ao aluno.
     */
	public void setMatriculas(ArrayList<Matricula> matriculas) {
		this.matriculas = matriculas;
	}
	
	
	/**
     * Solicita a matrícula do aluno em uma turma através de um administrador.
     *
     * @param admin O administrador responsável pela matrícula.
     * @param turma A turma a ser adicionada.
     * @param aluno O aluno que está solicitando a matrícula.
     * @return Uma mensagem de resposta da matrícula, geralmente de sucesso ou erro.
     */
    public String solicitarMatricula(Administrador admin, Turma turma, Aluno aluno) {
        return admin.matricularEmTurma(turma, aluno);
    }
    
    
    /**
    * Exibe todas as turmas disponíveis para o aluno visualizar.
    *
    * @param admin O administrador responsável pela gestão das turmas.
    * @return Uma string com as turmas disponíveis.
    */
    public String visualizarTurmasDisponiveis(Administrador admin) {
        return admin.listarTurmas();
    }
    
    
    /**
     * Busca uma turma através de seu código a partir do administrador.
     *
     * @param admin O administrador responsável pela gestão das turmas.
     * @param codigo O código da turma a ser buscada.
     * @return A turma correspondente ao código informado.
     */
    public Turma buscarTurmaParaInscrever(Administrador admin, String codigo) {
    	return admin.buscarTurmaPorCodigo(codigo);
    }
 
    
   
}
