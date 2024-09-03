package br.marcelo.web.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.marcelo.web.rest.entidades.Equipamento;
import br.marcelo.web.rest.excecoes.EquipamentoNaoEncontradoException;
import br.marcelo.web.rest.repositorio.EquipamentoRepositorio;

@RestController
public class EquipamentoController {
	
	private final EquipamentoRepositorio repositorio;
	private static final Logger log = LoggerFactory.getLogger(EquipamentoController.class);

	public EquipamentoController(EquipamentoRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	@PostMapping("/equipamentos")
	Equipamento novo(@RequestBody Equipamento novoEquipamento) {
		return repositorio.save(novoEquipamento);
	}
	
	@GetMapping("/equipamentos")
	List<Equipamento> listar(){
		return repositorio.findAll();
	}	
	
	@Cacheable("equipamentosCache")
	@GetMapping("/equipamentos/{id}")
	Equipamento obter(@PathVariable Long id){
		log.info("Procurando por equipamento ["+id+"]");
		
		return repositorio.findById(id)
				.orElseThrow(() -> new EquipamentoNaoEncontradoException(id));
	}
	
	@PutMapping("/equipamentos/{id}")
	Equipamento atualizar(@RequestBody Equipamento novoEquipamento, @PathVariable Long id) {
		
		return repositorio.findById(id)
				.map( equipamento -> {
					equipamento.setNome(novoEquipamento.getNome());
					equipamento.setLocal(novoEquipamento.getLocal());
					return repositorio.save(equipamento);
				})
				.orElseGet(()-> {
					return repositorio.save(novoEquipamento);
				});
	}
	
	@DeleteMapping("/equipamentos/{id}")
	void apagar(@PathVariable Long id){
		repositorio.deleteById(id);
	}
}
