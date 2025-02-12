package br.ifsp.lucasparila.interfaces;

import br.ifsp.lucasparila.model.Turma;


/**
 * Interface que define as operações que devem ser implementadas por todas as classes de usuários do sistema.
 * A interface garante que qualquer classe que a implemente terá métodos para buscar turmas, validar login,
 * visualizar matrículas e turmas disponíveis.
 */
public interface IUsuario {

	
	    
	 /**
     * Método para buscar uma turma pelo código.
     *
     * @param codigo O código da turma a ser buscada.
     * @return A turma correspondente ao código informado, ou null caso não encontrada.
     */
	 Turma buscarTurmaPorCodigo(String codigo);
	 

	 /**
	 * Método para validar a senha do usuário.
	 * 
	 * @param senha A senha informada para validação.
	 * @return Retorna verdadeiro se a senha for válida, caso contrário, retorna falso.
	 */
	 boolean validarLogin(String senha);
	 

	 /**
	 * Método para visualizar as matrículas do usuário.
	 *
	 * @return Uma string representando as matrículas associadas ao usuário.
	 */
	 String visualizarMatriculas();

	    
	 /**
	 * Método para visualizar as turmas disponíveis para o usuário.
	 *
	 * @return Uma string representando as turmas disponíveis.
	 */
	 String visualizarTurmasDisponiveis();


}
