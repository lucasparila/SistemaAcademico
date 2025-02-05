package br.ifsp.lucasparila;

public class Professor extends Usuario {
    // Construtor
    public Professor(String username, String senha, String prontuario, String nome, String dataNascimento) {
        super(username, senha, prontuario, nome, dataNascimento);
    }

    // Método para adicionar avaliação a uma disciplina
    public void adicionarAvaliacao(Disciplina disciplina, String nomeAvaliacao, double peso) {
        Avaliacao avaliacao = new Avaliacao(nomeAvaliacao, peso);
        disciplina.adicionarAvaliacao(avaliacao);
        System.out.println("Avaliação '" + nomeAvaliacao + "' adicionada à disciplina " + disciplina.getNome());
    }
    
    @Override
    public boolean validarLogin(String senha) {
    	return super.getSenha().equals(senha);
    }
}
