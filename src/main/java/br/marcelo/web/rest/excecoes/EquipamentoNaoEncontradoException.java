package br.marcelo.web.rest.excecoes;

public class EquipamentoNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EquipamentoNaoEncontradoException(Long id) {
		super("Não encontrado o equipamento: " + id);
	}

}
