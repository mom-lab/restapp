package br.marcelo.web.rest.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.marcelo.web.rest.entidades.Equipamento;

public interface EquipamentoRepositorio extends JpaRepository<Equipamento, Long>{

}
