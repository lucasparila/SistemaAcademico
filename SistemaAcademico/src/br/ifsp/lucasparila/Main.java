package br.ifsp.lucasparila;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {
	
    public static void main(String[] args) {
        Administrador admin = new Administrador("admin", "admin");
        boolean login = false;
        Usuario usuario = null;
        String tipoUsuario;
        
        do {
        	
        
	        do {
	            tipoUsuario = JOptionPane.showInputDialog("Escolha seu tipo de usuário:\n1 - Administrador\n2 - Aluno\n3 - Professor\n0 - Sair");
	            
	            if (tipoUsuario.equals("0")) {
	                break;
	            }
	            
	            String username = JOptionPane.showInputDialog("Digite seu username:");
	            
	            if (tipoUsuario.equals("1")) {
	                usuario = admin;
	            } else if (tipoUsuario.equals("2")) {
	                usuario = admin.buscarAlunoPorUsername(username);
	            } else if (tipoUsuario.equals("3")) {
	                usuario = admin.buscarProfessorPorUsername(username);
	            }
	            
	            if (usuario == null) {
	                JOptionPane.showMessageDialog(null, "Usuário não encontrado.");
	                continue;
	            }
	            
	            String senha = JOptionPane.showInputDialog("Digite sua senha:");
	            if (usuario.validarLogin(senha)) {
	                JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
	                login = true;
	            }
	            
	        }while(!login);
	        
	        
	        if(usuario instanceof Administrador && !tipoUsuario.equals("0")) {
	        	
	        	 while (true) {
	                 String menu = "Administrador\n"
	                         + "1. Cadastrar Aluno\n"
	                         + "2. Cadastrar Professor\n"
	                         + "3. Criar Turma\n"
	                         + "4. Cadastrar Disciplina\n"
	                         + "5. Matricular Aluno em Turma\n"
	                         + "6. Adicionar Avaliação\n"
	                         + "7. Visualizar Alunos\n"
	                         + "8. Visualizar Professores\n"
	                         + "9. Visualizar Turmas\n"
	                         + "10. Visualizar Disciplinas\n"
	                         + "0. Sair\n";
	                 
	                 String opcao = JOptionPane.showInputDialog(menu);
	
	                 if (opcao == null || opcao.equals("0")) {
	                     JOptionPane.showMessageDialog(null, "Voltando ao menu princiapal...");
	                     break;
	                 }
	             
	
	                 switch (opcao) {
	                     case "1":
	                         // Cadastrar aluno
	                         String usernameAluno = JOptionPane.showInputDialog("Digite o username do aluno:");
	                         String senhaAluno = JOptionPane.showInputDialog("Digite a senha do aluno:");
	                         String prontuarioAluno = JOptionPane.showInputDialog("Digite o prontuário do aluno:");
	                         String nomeAluno = JOptionPane.showInputDialog("Digite o nome do aluno:");
	                         String dataNascimentoAluno = JOptionPane.showInputDialog("Digite a data de nascimento do aluno:");
	                         admin.cadastrarAluno(usernameAluno, senhaAluno, prontuarioAluno, nomeAluno, dataNascimentoAluno);
	                         break;
	
	                     case "2":
	                         // Cadastrar professor
	                         String usernameProfessor = JOptionPane.showInputDialog("Digite o username do professor:");
	                         String senhaProfessor = JOptionPane.showInputDialog("Digite a senha do professor:");
	                         String prontuarioProfessor = JOptionPane.showInputDialog("Digite o prontuário do professor:");
	                         String nomeProfessor = JOptionPane.showInputDialog("Digite o nome do professor:");
	                         String dataNascimentoProfessor = JOptionPane.showInputDialog("Digite a data de nascimento do professor:");
	                         admin.cadastrarProfessor(usernameProfessor, senhaProfessor, prontuarioProfessor, nomeProfessor, dataNascimentoProfessor);
	                         break;
	
	                     case "3":
	                         // Criar turma
	                         String codigoTurma = JOptionPane.showInputDialog("Digite o código da turma:");
	                         String usernameProfessorTurma = JOptionPane.showInputDialog("Digite o username do professor para vincular à turma:");
	                         String siglaDisciplinaTurma = JOptionPane.showInputDialog("Digito a sigla da disciplina que será vinculada a turma: ");
	                         admin.criarTurma(codigoTurma, usernameProfessorTurma, siglaDisciplinaTurma);
	                         break;
	
	                     case "4":
	                         // Cadastrar disciplina
	                         String nomeDisciplina = JOptionPane.showInputDialog("Digite o nome da disciplina:");
	                         String siglaDisciplina = JOptionPane.showInputDialog("Digite a sigla da disciplina:");
	                         String emendaDisciplina = JOptionPane.showInputDialog("Digite a emenda da disciplina:");
	                         int cargaHorariaDisciplina = Integer.parseInt(JOptionPane.showInputDialog("Digite a carga horária da disciplina:"));
	                         int totalAulasDisciplina = Integer.parseInt(JOptionPane.showInputDialog("Digite o total de aulas da disciplina:"));
	                         admin.cadastrarDisciplina(nomeDisciplina, siglaDisciplina, emendaDisciplina, cargaHorariaDisciplina, totalAulasDisciplina);
	                         break;
	
	                     case "5":
	                         // Matricular aluno em turma
	                         String usernameAlunoMatricula = JOptionPane.showInputDialog("Digite o username do aluno para matrícula:");
	                         String codigoTurmaMatricula = JOptionPane.showInputDialog("Digite o código da turma para matrícula:");
	                         Aluno alunoMatricula = admin.buscarAlunoPorUsername(usernameAlunoMatricula);
	                         Turma turmaMatricula = admin.buscarTurmaPorCodigo(codigoTurmaMatricula);
	                         if (alunoMatricula != null && turmaMatricula != null) {
	                             alunoMatricula.matricularEmTurma(turmaMatricula);
	                             JOptionPane.showMessageDialog(null, "Aluno matriculado com sucesso!");
	                         } else {
	                             JOptionPane.showMessageDialog(null, "Aluno ou turma não encontrados.");
	                         }
	                         break;
	
	                     case "6":
	                         // Adicionar avaliação
	                         String nomeAvaliacao = JOptionPane.showInputDialog("Digite o nome da avaliação:");
	                         double pesoAvaliacao = Double.parseDouble(JOptionPane.showInputDialog("Digite o peso da avaliação:"));                  
	                         String siglaDisciplinaAvaliacoes = JOptionPane.showInputDialog("Digite a sigla da disciplina para adicionar a avaliação:");
	                         Disciplina disciplinaAvaliacao = admin.buscarDisciplinaPorSigla(siglaDisciplinaAvaliacoes);
	                         if (disciplinaAvaliacao != null) {
	                             disciplinaAvaliacao.adicionarAvaliacao(new Avaliacao(nomeAvaliacao, pesoAvaliacao));
	                             JOptionPane.showMessageDialog(null, "Avaliação adicionada com sucesso!");
	                         } else {
	                             JOptionPane.showMessageDialog(null, "Disciplina não encontrada.");
	                         }
	                         break;
	
	                     case "7":
	                         // Visualizar alunos
	                         String alunosList = admin.listarAlunos();
	                         JOptionPane.showMessageDialog(null, alunosList);
	                         break;
	
	                     case "8":
	                         // Visualizar professores
	                         String professoresList = admin.listarProfessores();
	                         JOptionPane.showMessageDialog(null, professoresList);
	                         break;
	
	                     case "9":
	                         // Visualizar turmas
	                         String turmasList = admin.listarTurmas();
	                         JOptionPane.showMessageDialog(null, turmasList);
	                         break;
	
	                     case "10":
	                         // Visualizar disciplinas
	                         String disciplinasList = admin.listarDisciplinas();
	                         JOptionPane.showMessageDialog(null, disciplinasList);
	                         break;
	
	                     default:
	                         JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
	                 }
	        	 }
	        		
	        }else if(usuario instanceof Professor && !tipoUsuario.equals("0")) {
	        	
	        	
	        	
	        	
	        	
	        	
	        	
	        	
	        	
	        	
	        	
	        }else if(usuario instanceof Aluno && !tipoUsuario.equals("0")) {
	        	
	        	Aluno aluno = (Aluno) usuario;
	        	Administrador administrador = new Administrador("admin", "admin");
	        	
	        	 while (true) {
	                 String menu = "Aluno" + aluno.getNome() + "\n"
	                         + "1. Visualizar turmas\n"
	                         + "2. Inscrever-se em uma turma\n"
	                         + "3. Boletim\n"
	                         + "0. Sair\n";
	                 
	                 String opcao = JOptionPane.showInputDialog(menu);
	
	                 if (opcao == null || opcao.equals("0")) {
	                     JOptionPane.showMessageDialog(null, "Voltando ao menu princiapal...");
	                     break;
	                 }
	             
	
	                 switch (opcao) {
	                     case "1":
	                         // Visualisar tumar	                 
	                    	 List<Turma> turmasDisponiveis = new ArrayList<>();
	                    	 turmasDisponiveis = administrador.getTurmas();
	                         String turmasList = aluno.visualizarTurmasDisponiveis(turmasDisponiveis);
	                         JOptionPane.showMessageDialog(null, turmasList);
	                         break;
	
	                     case "2":
	                         // Inscrever-se em uma turma	                    	 	                    	                 	 
	                         String codigoTurma = JOptionPane.showInputDialog("Digite o codigo da turma:");	                         
	                         Turma turma = admin.buscarTurmaPorCodigo(codigoTurma);
	                         if(turma.equals(null)) {
	                        	 JOptionPane.showMessageDialog(null, "Não existe nenhuma turma com o código informado.");
	                         }else {
	                        	 JOptionPane.showMessageDialog(null, aluno.matricularEmTurma(turma));
	                         }
	                         break;
	
	                     case "3":
	                         // boletim 
	                    	 String listMatriculas = aluno.visualizarMatriculas();
	                    	 JOptionPane.showMessageDialog(null, listMatriculas);
	                         break;
	
	                     default:
	                         JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
	                 }
	        	 }
	        	
	        }
	        
        if(tipoUsuario.equals("0")) {
        	JOptionPane.showMessageDialog(null, "Saindo do sistema...");							
        }
    }while(!tipoUsuario.equals("0"));
 }
}