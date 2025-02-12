package br.ifsp.lucasparila.model;

import java.util.ArrayList;
import java.util.List;


/**
 * Classe que representa um Administrador, responsável por gerenciar alunos, professores, disciplinas e turmas.
 * O Administrador tem a capacidade de cadastrar, listar, atualizar e remover alunos, professores, turmas e disciplinas.
 */
public class Administrador extends Usuario {
    
    private List<Aluno> alunos = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();
    protected List<Turma> turmas = new ArrayList<>();

    /**
     * Construtor da classe Administrador.
     *
     * @param username O nome de usuário do administrador.
     * @param senha A senha do administrador.
     */
    public Administrador(String username, String senha) {
        super(username, senha, null, null, null); // Administrador não tem prontuário, nome ou data de nascimento
    }
    

    /**
     * Método para cadastrar um aluno.
     *
     * @param username O nome de usuário do aluno.
     * @param senha A senha do aluno.
     * @param prontuario O prontuário do aluno.
     * @param nome O nome do aluno.
     * @param dataNascimento A data de nascimento do aluno.
     */
    public void cadastrarAluno(String username, String senha, String prontuario, String nome, String dataNascimento) {
        Aluno aluno = new Aluno(username, senha, prontuario, nome, dataNascimento);
        alunos.add(aluno);  
    }
    
    
    /**
     * Método para validar o login de um administrador.
     *
     * @param senha A senha para validação.
     * @return Retorna true se a senha for válida, caso contrário, retorna false.
     */
    @Override
    public boolean validarLogin(String senha) {
    	return super.getSenha().equals(senha);
    }
    
    
    /**
     * Método para listar os alunos cadastrados.
     *
     * @return Uma string com a lista de alunos cadastrados.
     */
    public String listarAlunos() {
        StringBuilder sb = new StringBuilder();
        if (alunos.isEmpty()) {
            sb.append("Nenhum aluno cadastrado.");
        } else {
            sb.append("Lista de Alunos:\n");
            for (Aluno aluno : alunos) {
                sb.append("Username: ").append(aluno.getUsername()).append("\n");
                sb.append("Prontuário: ").append(aluno.getProntuario()).append("\n");
                sb.append("Nome: ").append(aluno.getNome()).append("\n");
                sb.append("Data de Nascimento: ").append(aluno.getDataNascimento()).append("\n");
                sb.append("-------------------\n");
            }
        }
        return sb.toString();
    }
    
    
    /**
     * Método para remover um aluno da lista.
     *
     * @param aluno O aluno a ser removido.
     */
    public void removerAluno(Aluno aluno) {
    	alunos.remove(aluno);
    }

    
    /**
     * Método para listar os professores cadastrados.
     *
     * @return Uma string com a lista de professores cadastrados.
     */
    public String listarProfessores() {
        StringBuilder sb = new StringBuilder();
        if (professores.isEmpty()) {
            sb.append("Nenhum professor cadastrado.");
        } else {
            sb.append("Lista de Professores:\n");
            for (Professor professor : professores) {
                sb.append("Username: ").append(professor.getUsername()).append("\n");
                sb.append("Prontuário: ").append(professor.getProntuario()).append("\n");
                sb.append("Nome: ").append(professor.getNome()).append("\n");
                sb.append("Data de Nascimento: ").append(professor.getDataNascimento()).append("\n");
                sb.append("-------------------\n");
            }
        }
        return sb.toString();
    }


    /**
     * Método para cadastrar um professor.
     *
     * @param username O nome de usuário do professor.
     * @param senha A senha do professor.
     * @param prontuario O prontuário do professor.
     * @param nome O nome do professor.
     * @param dataNascimento A data de nascimento do professor.
     */
    public void cadastrarProfessor(String username, String senha, String prontuario, String nome, String dataNascimento) {
        Professor professor = new Professor(username, senha, prontuario, nome, dataNascimento);
        professores.add(professor);   
    }
    

    /**
     * Método para cadastrar uma disciplina.
     *
     * @param disciplina A disciplina a ser cadastrada.
     */
    public void cadastrarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);        
    }
    

    /**
     * Método para criar uma turma.
     *
     * @param turma A turma a ser criada.
     * @param professor O professor responsável pela turma.
     */
    public void criarTurma(Turma turma, Professor professor) {
            turmas.add(turma);
            professor.adicionarProfessor(turma);
            
    }
    
    
    /**
     * Método para visualizar as matrículas dos alunos.
     *
     * @return Uma string com as matrículas de todos os alunos.
     */
    public String visualizarMatriculas() {
    	StringBuilder sb= new StringBuilder();
    	for(Aluno a : alunos) {
    		sb.append("Aluno: ").append(a.getNome());
	        if (a.getMatriculas().isEmpty()) {
	            sb.append("Nenhuma matrícula realizada.");
	        } else {
	            sb.append("Matrículas do Aluno:");
	            for (Matricula matricula : a.getMatriculas()) {
	                sb.append(matricula.visualizarMatricula());
	            }
	        }
    	}
        return sb.toString();
   }
    
    
    /**
     * Método para listar todas as turmas.
     *
     * @return Uma string com todas as turmas cadastradas.
     */
    public String listarTurmas() {
        StringBuilder sb = new StringBuilder();
        if (turmas.isEmpty()) {
            sb.append("Nenhuma turma cadastrada.");
        } else {
            sb.append("Lista de Turmas:\n");
            for (Turma turma : turmas) {
                sb.append("Código da Turma: ").append(turma.getCodigo()).append("\n");
                if(turma.getProfessor() == null) {
                	sb.append("Professor Responsável: ").append(" - ").append("\n");               	
                }else {
                	sb.append("Professor Responsável: ").append(turma.getProfessor().getNome()).append("\n");                	
                }
                
                sb.append("Disciplina: ").append(turma.getDisciplina().getNome()).append("\n");
                sb.append("-------------------\n");
            }
        }
        return sb.toString();
    }
    
    /**
    * Retorna a lista de todas as turmas cadastradas.
    *
    * @return Uma lista de objetos {@link Turma} contendo todas as turmas cadastradas.
    */
    public List<Turma> getTurmas() {
        return turmas;
    }
   
    
    /**
     * Gera uma lista formatada de todas as disciplinas cadastradas.
     * Caso não haja disciplinas cadastradas, retorna uma mensagem informando.
     *
     * @return Uma string contendo a lista de disciplinas, com detalhes como nome, sigla, emenda, carga horária e total de aulas, ou uma mensagem indicando que não há disciplinas cadastradas.
     */
    public String listarDisciplinas() {
        StringBuilder sb = new StringBuilder();
        if (disciplinas.isEmpty()) {
            sb.append("Nenhuma disciplina cadastrada.");
        } else {
            sb.append("Lista de Disciplinas:\n");
            for (Disciplina disciplina : disciplinas) {
                sb.append("Nome: ").append(disciplina.getNome()).append("\n");
                sb.append("Sigla: ").append(disciplina.getSigla()).append("\n");
                sb.append("Emenda: ").append(disciplina.getEmenda()).append("\n");
                sb.append("Carga Horária: ").append(disciplina.getCargaHoraria()).append("\n");
                sb.append("Total de Aulas: ").append(disciplina.getTotalAulas()).append("\n");
                sb.append("-------------------\n");
            }
        }
        return sb.toString();
    }

   
    /**
     * Busca uma disciplina com base na sua sigla.
     *
     * @param sigla A sigla da disciplina a ser buscada.
     * @return O objeto {@link Disciplina} correspondente à sigla informada, ou null se não encontrado.
     */
    public Disciplina buscarDisciplinaPorSigla(String sigla) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getSigla().equals(sigla)) {
                return disciplina;
            }
        }
        return null; 
    }
    
    
    
    /**
     * Remove uma disciplina da lista de disciplinas cadastradas.
     *
     * @param disciplina O objeto {@link Disciplina} a ser removido.
     */
    public void disciplinaRemover(Disciplina disciplina) {
    	disciplinas.remove(disciplina);
    }

    
    /**
    * Remove uma turma da lista de turmas cadastradas.
    *
    * @param turma O objeto {@link Turma} a ser removido.
    */
    public void removerTurma(Turma turma) {
           turmas.remove(turma);
           
    }

    
    /**
     * Atualiza os dados de uma turma, como o código, professor responsável e disciplina.
     * Caso não encontre a turma, professor ou disciplina, a atualização não será realizada.
     * 
     * @param codigo O código da turma a ser atualizada.
     * @param novoCodigo O novo código da turma.
     * @param usernameProfessor O nome de usuário do professor responsável pela turma.
     * @param siglaDisciplina A sigla da disciplina atribuída à turma.
     */
    public void atualizarTurma(String codigo, String novoCodigo, String usernameProfessor, String siglaDisciplina) {
        Turma turma = buscarTurmaPorCodigo(codigo);
        if (turma != null) {
            Professor professor = buscarProfessorPorUsername(usernameProfessor);
            Disciplina disciplina = buscarDisciplinaPorSigla(siglaDisciplina);
            if (professor != null && disciplina != null) {
                turma.setCodigo(novoCodigo);
                turma.setProfessor(professor);
                turma.setDisciplina(disciplina);
                System.out.println("Turma atualizada com sucesso: " + novoCodigo);
            } else {
                System.out.println("Professor ou Disciplina não encontrados. Nenhuma atualização realizada.");
            }
        } else {
            System.out.println("Turma não encontrada. Nenhuma atualização realizada.");
        }
    }
    
    
    /**
     * Método para buscar uma turma pelo código.
     *
     * @param codigo O código da turma.
     * @return A turma correspondente ao código, ou null se não encontrada.
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
     * Método para visualizar as turmas disponíveis.
     *
     * @return Uma string com todas as turmas disponíveis.
     */
    public String visualizarTurmasDisponiveis() {
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
    
    
    
    /**
     * Remove todas as matrículas de um aluno em suas turmas.
     * Para cada matrícula do aluno, verifica-se a turma correspondente e a matrícula é removida dessa turma.
     *
     * @param aluno O objeto {@link Aluno} do qual as matrículas serão removidas.
     */
    public void retirarAlunoTurmas(Aluno aluno) {
    	ArrayList<Matricula> matriculas = new ArrayList<>();
    	matriculas = aluno.getMatriculas();
    	
    	for(Matricula m : matriculas) {
    		for(Turma t : turmas) {
    			if(m.getTurma().equals(t)) {
    				t.removerMatricula(m);
    			}
    		}
    	}
    }
    
    
    
    /**
     * Método para matricular um aluno em uma turma.
     *
     * @param turma A turma onde o aluno será matriculado.
     * @param aluno O aluno a ser matriculado.
     * @return Uma mensagem de sucesso ou erro.
     */
    public String matricularEmTurma(Turma turma, Aluno aluno) {
    	StringBuilder sb= new StringBuilder();
        Matricula matricula = new Matricula(aluno, turma);
        turma.adicionarMatricula(matricula);
        aluno.getMatriculas().add(matricula);
        if(!turma.turmaAvaliacoesVazia()) {
        	turma.adicionarAvaliacoesMatriculas();
        }        
        sb.append("Matrícula realizada com sucesso para a turma: " + turma.getCodigo());
        
        return sb.toString();
    }
    

    /**
     * Busca um aluno pelo seu username.
     *
     * @param username O nome de usuário do aluno.
     * @return O objeto {@link Aluno} correspondente ao username informado, ou null se não encontrado.
     */
    public Aluno buscarAlunoPorUsername(String username) {
        for (Aluno aluno : alunos) {
            if (aluno.getUsername().equals(username)) {
                return aluno;
            }
        }
        return null;
    }

    
    /**
     * Busca um professor pelo seu username.
     *
     * @param username O nome de usuário do professor.
     * @return O objeto {@link Professor} correspondente ao username informado, ou null se não encontrado.
     */
    public Professor buscarProfessorPorUsername(String username) {
        for (Professor professor : professores) {
            if (professor.getUsername().equals(username)) {
                return professor;
            }
        }
        return null;
    }
    
    
    /**
     * Remove um professor da lista de professores cadastrados.
     * 
     * @param professor O objeto {@link Professor} a ser removido.
     */
    public void removerProfessor(Professor professor) {
    	professores.remove(professor);
    }
    
      
    /**
     * Atualiza as informações de um usuário, como username, senha, nome, prontuário e data de nascimento.
     * 
     * @param usuario O objeto {@link Usuario} a ser atualizado.
     * @param username O novo username para o usuário.
     * @param senha A nova senha para o usuário.
     * @param nome O novo nome do usuário.
     * @param prontuario O novo prontuário do usuário.
     * @param dataNascimento A nova data de nascimento do usuário.
     */
    public void setUsuario(Usuario usuario, String username, String senha, String nome, String prontuario, String dataNascimento) {
    	
    	usuario.setUsername(username);
    	usuario.setSenha(senha);
    	usuario.setNome(nome);
    	usuario.setProntuario(prontuario);
    	usuario.setDataNascimento(dataNascimento);
    }
    
    
    /**
     * Atualiza as informações de uma disciplina, como nome, sigla, emenda, carga horária e total de aulas.
     * 
     * @param disciplina O objeto {@link Disciplina} a ser atualizado.
     * @param nome O novo nome da disciplina.
     * @param sigla A nova sigla da disciplina.
     * @param emenda A nova emenda da disciplina.
     * @param cargaHoraria A nova carga horária da disciplina.
     * @param totalAulas O novo total de aulas da disciplina.
     */
   public void setDisciplina(Disciplina disciplina,String nome, String sigla, String emenda, int cargaHoriara, int totalAulas) {
	   disciplina.setNome(nome);
	   disciplina.setSigla(sigla);
	   disciplina.setEmenda(emenda);
	   disciplina.setCargaHoraria(cargaHoriara);
	   disciplina.setTotalAulas(totalAulas);
   }
    
   
   /**
    * Atualiza o código de uma turma.
    * 
    * @param turma O objeto {@link Turma} a ser atualizado.
    * @param novoCodigo O novo código da turma.
    */
   public void setNomeTurma(Turma turma, String novoCodigo) {
	   turma.setCodigo(novoCodigo);
   }
   
   
   /**
    * Atualiza o professor responsável por uma turma.
    * 
    * @param turma O objeto {@link Turma} a ser atualizado.
    * @param professor O objeto {@link Professor} que será designado como responsável pela turma.
    */
   public void setProfessorTurma(Turma turma, Professor professor) {
	   turma.setProfessor(professor);
   }
   
   
   /**
    * Retorna a lista de disciplinas cadastradas.
    * 
    * @return Uma lista de objetos {@link Disciplina} com todas as disciplinas cadastradas.
    */
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}


