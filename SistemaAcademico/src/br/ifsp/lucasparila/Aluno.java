package br.ifsp.lucasparila;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    private ArrayList<Matricula> matriculas = new ArrayList<>();

    // Construtor
    public Aluno(String username, String senha, String prontuario, String nome, String dataNascimento) {
        super(username, senha, prontuario, nome, dataNascimento);
    }

    
    @Override
    public boolean validarLogin(String senha) {
    	return super.getSenha().equals(senha);
    }
    
    // Método para visualizar as turmas disponíveis
    public String visualizarTurmasDisponiveis(List<Turma> list) {
    	StringBuilder sb= new StringBuilder();
        if (list.isEmpty()) {
            sb.append("Nenhuma turma disponível.");
        } else {
            sb.append("Turmas Disponíveis:");
            for (Turma turma : list) {
                sb.append(turma.visualizarInformacoes());
                
            }
        }
        
        return sb.toString();
    }

    // Método para se matricular em uma turma
    public String matricularEmTurma(Turma turma) {
    	StringBuilder sb= new StringBuilder();
        Matricula matricula = new Matricula(this, turma);
        matriculas.add(matricula);
        sb.append("Matrícula realizada com sucesso para a turma: " + turma.getCodigo());
        
        return sb.toString();
    }

    // Método para visualizar as matrículas do aluno
    public String visualizarMatriculas() {
    	StringBuilder sb= new StringBuilder();
        if (matriculas.isEmpty()) {
            sb.append("Nenhuma matrícula realizada.");
        } else {
            sb.append("Matrículas do Aluno:");
            for (Matricula matricula : matriculas) {
                sb.append(matricula.visualizarMatricula());
            }
        }
        
        return sb.toString();
    }
    
 // Método para visualizar turmas em que o aluno está matriculado
    public String visualizarTurmas() {
    	StringBuilder sb= new StringBuilder();
        if (matriculas.isEmpty()) {
            sb.append(super.getNome() + " não está matriculado em nenhuma turma.");
        } else {
            sb.append("Turmas nas quais " + super.getNome() + " está matriculado:");
            for (Matricula matricula : matriculas) {
               sb.append(matricula.getTurma().visualizarInformacoes());
                sb.append("-------------------");
            }
        }
        
        return sb.toString();
    }

}
