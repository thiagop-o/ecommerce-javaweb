package br.com.decommerce.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.decommerce.interceptors.SomenteLogado;
import br.com.decommerce.model.Categoria;
import br.com.olimposistema.aipa.dao.DAO;

@Controller
@Path("deletacategoria")
public class DeletaCategoriaController {
	
	@Inject DAO<Categoria> categoriaDAO;
	@Inject Result result;

	@Get("/{categoria.id}")
	@SomenteLogado
	public void deletacategoria(Categoria categoria) {
		categoriaDAO.delete(categoria);
		result.redirectTo(CategoriasController.class).categorias();
	}
	
}
