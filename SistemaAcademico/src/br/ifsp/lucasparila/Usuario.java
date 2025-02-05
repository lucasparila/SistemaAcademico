package br.ifsp.lucasparila;

public abstract class Usuario {
    private String username;
    private String senha;
    private String prontuario;
    private String nome;
    private String dataNascimento;

    // Construtor
    public Usuario(String username, String senha, String prontuario, String nome, String dataNascimento) {
        this.username = username;
        this.senha = senha;
        this.prontuario = prontuario;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    // Getters e Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public abstract boolean validarLogin(String senha);

    // Método para visualizar informações
    public void visualizarInformacoes() {
        System.out.println("Username: " + username);
        System.out.println("Prontuário: " + prontuario);
        System.out.println("Nome: " + nome);
        System.out.println("Data de Nascimento: " + dataNascimento);
    }
}