package br.ifsp.lucasparila;

public class Turma {
    private String codigo;
    private Professor professor;
    private Disciplina disciplina;

    // Construtor
    public Turma(String codigo, Professor professor, Disciplina disciplina) {
        this.codigo = codigo;
        this.professor = professor;
        this.disciplina = disciplina;
    }

    // Getters e Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    // Método para visualizar informações da turma
    public String visualizarInformacoes() {
    	StringBuilder sb= new StringBuilder();
    	
        sb.append("Código da Turma: " + codigo);
        sb.append("Professor Responsável: " + professor.getNome());
        sb.append("Disciplina: " + disciplina.visualizarInformacoes());
        
        return sb.toString();
    }
    
    

}

