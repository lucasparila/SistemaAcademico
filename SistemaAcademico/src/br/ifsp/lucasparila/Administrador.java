package br.ifsp.lucasparila;

import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario {
    // Listas para armazenar alunos, professores, turmas e disciplinas
    private List<Aluno> alunos = new ArrayList<>();
    private List<Professor> professores = new ArrayList<>();
    private List<Turma> turmas = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();

    // Construtor
    public Administrador(String username, String senha) {
        super(username, senha, null, null, null); // Administrador não tem prontuário, nome ou data de nascimento
    }

    // Método para cadastrar alunos
    public void cadastrarAluno(String username, String senha, String prontuario, String nome, String dataNascimento) {
        Aluno aluno = new Aluno(username, senha, prontuario, nome, dataNascimento);
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso: " + aluno.getNome());
    }
    
    @Override
    public boolean validarLogin(String senha) {
    	return super.getSenha().equals(senha);
    }
    
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


    // Método para cadastrar professores
    public void cadastrarProfessor(String username, String senha, String prontuario, String nome, String dataNascimento) {
        Professor professor = new Professor(username, senha, prontuario, nome, dataNascimento);
        professores.add(professor);
        System.out.println("Professor cadastrado com sucesso: " + professor.getNome());
    }

    // Método para cadastrar disciplinas
    public void cadastrarDisciplina(String nome, String sigla, String emenda, int cargaHoraria, int totalAulas) {
        Disciplina disciplina = new Disciplina(nome, sigla, emenda, cargaHoraria, totalAulas);
        disciplinas.add(disciplina);
        System.out.println("Disciplina cadastrada com sucesso: " + disciplina.getNome());
    }

    // Método para criar uma turma
    public void criarTurma(String codigo, String usernameProfessor, String siglaDisciplina) {
        Professor professor = buscarProfessorPorUsername(usernameProfessor);
        Disciplina disciplina = buscarDisciplinaPorSigla(siglaDisciplina);
        if (professor != null && disciplina != null) {
            Turma turma = new Turma(codigo, professor, disciplina);
            turmas.add(turma);
            System.out.println("Turma criada com sucesso: " + codigo);
        } else {
            System.out.println("Professor ou Disciplina não encontrados. Turma não criada.");
        }
    }

    public String listarTurmas() {
        StringBuilder sb = new StringBuilder();
        if (turmas.isEmpty()) {
            sb.append("Nenhuma turma cadastrada.");
        } else {
            sb.append("Lista de Turmas:\n");
            for (Turma turma : turmas) {
                sb.append("Código da Turma: ").append(turma.getCodigo()).append("\n");
                sb.append("Professor Responsável: ").append(turma.getProfessor().getNome()).append("\n");
                sb.append("Disciplina: ").append(turma.getDisciplina().getNome()).append("\n");
                sb.append("-------------------\n");
            }
        }
        return sb.toString();
    }


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

    // Método para buscar uma turma pelo código
    public Turma buscarTurmaPorCodigo(String codigo) {
        for (Turma turma : turmas) {
            if (turma.getCodigo().equals(codigo)) {
                return turma;
            }
        }
        return null; // Retorna null se não encontrar
    }

    // Método para buscar uma disciplina pela sigla
    public Disciplina buscarDisciplinaPorSigla(String sigla) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getSigla().equals(sigla)) {
                return disciplina;
            }
        }
        return null; // Retorna null se não encontrar
    }

    // Método para remover uma turma
    public void removerTurma(String codigo) {
        Turma turma = buscarTurmaPorCodigo(codigo);
        if (turma != null) {
            turmas.remove(turma);
            System.out.println("Turma removida com sucesso: " + codigo);
        } else {
            System.out.println("Turma não encontrada. Nenhuma remoção realizada.");
        }
    }

    // Método para atualizar uma turma
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

    // Métodos de busca por aluno e professor
    public Aluno buscarAlunoPorUsername(String username) {
        for (Aluno aluno : alunos) {
            if (aluno.getUsername().equals(username)) {
                return aluno;
            }
        }
        return null;
    }

    public Professor buscarProfessorPorUsername(String username) {
        for (Professor professor : professores) {
            if (professor.getUsername().equals(username)) {
                return professor;
            }
        }
        return null;
    }
    
 // Método para obter todas as turmas
    public List<Turma> getTurmas() {
        return turmas;
    }
    
 // Método para retornar a lista de disciplinas
    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}


