package br.marcelo.web.rest.excecoes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratamentoEquipamentoNaoEncontrado {
	private static final Logger log = LoggerFactory.getLogger(TratamentoEquipamentoNaoEncontrado.class);
	
	@ExceptionHandler(EquipamentoNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String equipamentoNaoEncontradoHandler(EquipamentoNaoEncontradoException ex) {
		log.error("Tratamento do response de erro para equipamento nao encontrado");
		return ex.getMessage();
	}
}
