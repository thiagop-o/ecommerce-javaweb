package br.com.decommerce.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.olimposistema.aipa.model.Model;

@Entity 
public class Categoria extends Model{
	@NotEmpty
	@Column(unique = true)
	@Size(min = 2, max = 255,message = "{categoria.nome.size}")
	private String nome;
	
	@OneToMany(mappedBy = "categoria") //Classe para metodo
	private List<Produto> produto;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
