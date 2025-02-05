package br.ifsp.lucasparila;

public class Matricula {
    private Aluno aluno;
    private Turma turma;

    // Construtor
    public Matricula(Aluno aluno, Turma turma) {
        this.aluno = aluno;
        this.turma = turma;
    }

    // Getters e Setters
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    // Método para visualizar a matrícula
    public String visualizarMatricula() {
    	StringBuilder sb = new StringBuilder();
        sb.append("Aluno: " + aluno.getNome());
        sb.append("Matriculado na turma: " + turma.getCodigo());
        sb.append("Disciplina: " + turma.getDisciplina().getNome());
        sb.append("Avaliações:\n" + turma.getDisciplina());
        sb.append("----------------------------");
        
        return sb.toString();
    }

}
