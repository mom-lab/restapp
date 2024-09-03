package br.marcelo.web.rest.configuracao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.marcelo.web.rest.entidades.Equipamento;
import br.marcelo.web.rest.repositorio.EquipamentoRepositorio;

@Configuration
public class CarregarDadosNoDB {
	
	private static final Logger log = LoggerFactory.getLogger(CarregarDadosNoDB.class);

	@Bean
	CommandLineRunner initDatabase(EquipamentoRepositorio repositorio) {
		
		return args -> {
			log.info("Carregando "+repositorio.save(new Equipamento("cto10", "sp")));
			log.info("Carregando "+repositorio.save(new Equipamento("olt11", "rj")));
			log.info("Carregando "+repositorio.save(new Equipamento("drop20", "mg")));
		};
	}
			
}
