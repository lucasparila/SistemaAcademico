package br.ifsp.lucasparila.model;

import br.ifsp.lucasparila.interfaces.IUsuario;

/**
 * Classe abstrata que representa um usuário do sistema, contendo informações como nome, username, senha e prontuário.
 * Implementa a interface IUsuario.
 */
public abstract class Usuario implements IUsuario {
    private String username;
    private String senha;
    private String prontuario;
    private String nome;
    private String dataNascimento;
    
    /**
     * Construtor para inicializar os atributos do usuário.
     *
     * @param username        O nome de usuário do usuário.
     * @param senha           A senha do usuário.
     * @param prontuario      O prontuário do usuário.
     * @param nome            O nome completo do usuário.
     * @param dataNascimento  A data de nascimento do usuário.
     */
    public Usuario(String username, String senha, String prontuario, String nome, String dataNascimento) {
        this.username = username;
        this.senha = senha;
        this.prontuario = prontuario;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    
    /**
     * Obtém o nome de usuário do usuário.
     *
     * @return O nome de usuário.
     */
    public String getUsername() {
        return username;
    }

    
    /**
     * Define o nome de usuário do usuário.
     *
     * @param username O nome de usuário a ser atribuído.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    
    /**
     * Obtém a senha do usuário.
     *
     * @return A senha do usuário.
     */
    public String getSenha() {
        return senha;
    }

    
    /**
     * Define a senha do usuário.
     *
     * @param novaSenha A nova senha a ser atribuída.
     */
    public void setSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    
    /**
     * Obtém o prontuário do usuário.
     *
     * @return O prontuário do usuário.
     */
    public String getProntuario() {
        return prontuario;
    }

    
    /**
     * Define o prontuário do usuário.
     *
     * @param prontuario O prontuário a ser atribuído.
     */
    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    
    /**
     * Obtém o nome completo do usuário.
     *
     * @return O nome completo do usuário.
     */
    public String getNome() {
        return nome;
    }

    
    /**
     * Define o nome completo do usuário.
     *
     * @param nome O nome completo a ser atribuído.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    /**
     * Obtém a data de nascimento do usuário.
     *
     * @return A data de nascimento do usuário.
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    
    /**
     * Define a data de nascimento do usuário.
     *
     * @param dataNascimento A data de nascimento a ser atribuída.
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
    /**
     * Valida o login do usuário, verificando se a senha informada é correta.
     *
     * @param senha A senha informada para validação.
     * @return Retorna verdadeiro se a senha for válida, caso contrário, retorna falso.
     */
    public abstract boolean validarLogin(String senha);
    

    /**
     * Busca uma turma pelo código, retornando a turma correspondente.
     *
     * @param codigo O código da turma a ser buscada.
     * @return A turma correspondente ao código, ou null caso não encontrada.
     */
    public abstract Turma buscarTurmaPorCodigo(String codigo);

    
    /**
     * Visualiza as matrículas do usuário.
     *
     * @return Uma string representando as matrículas do usuário.
     */
    public abstract String visualizarMatriculas();

   
    /**
     * Visualiza as turmas disponíveis para o usuário.
     *
     * @return Uma string representando as turmas disponíveis.
     */
    public abstract String visualizarTurmasDisponiveis();


    /**
     * Método para visualizar as informações do usuário (nome, prontuário, etc).
     */
    public void visualizarInformacoes() {
        System.out.println("Username: " + username);
        System.out.println("Prontuário: " + prontuario);
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dataNascimento);
    }
   
}