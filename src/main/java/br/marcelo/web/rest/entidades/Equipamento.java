package br.marcelo.web.rest.entidades;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Equipamento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private @Id
	@GeneratedValue Long id;
	private String nome;
	private String local;
	
	

	public Equipamento() {
	}

	public Equipamento(String nome, String local) {
		this.nome = nome;
		this.local = local;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	@Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Equipamento))
	      return false;
	    Equipamento equipamento = (Equipamento) o;
	    return Objects.equals(this.id, equipamento.id) && Objects.equals(this.nome, equipamento.nome)
	        && Objects.equals(this.local, equipamento.local);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.nome, this.local);
	  }

	@Override
	public String toString() {
		return "Equipamento [id=" + id + ", nome=" + nome + ", local=" + local + "]";
	}

	  

}
