package br.com.decommerce.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.decommerce.model.Categoria;
import br.com.olimposistema.aipa.dao.DAO;
import br.com.olimposistema.aipa.vraptorcrud.CrudRest;

@Controller
@Path("categoria")
public class CategoriaController extends CrudRest<Categoria>{
	
	@Inject Result result;
	
	@Inject
	public CategoriaController(DAO<Categoria> dao) {
		super(Categoria.class, dao);
		
	}
	
	@Deprecated
	public CategoriaController() {this (null);}
}
