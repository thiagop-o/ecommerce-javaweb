package br.com.decommerce.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.decommerce.interceptors.SomenteLogado;
import br.com.decommerce.model.Categoria;
import br.com.olimposistema.aipa.dao.DAO;

@Controller
@Path("categorias")
public class CategoriasController {
	@Inject HttpSession session;	
	@Inject Result result;
	@Inject DAO<Categoria> categoriaDAO;
	
	@Get("")
	@SomenteLogado
	public void categorias() {
		//buscar no banco
		List<Categoria> categorias = categoriaDAO.selectAll();
		
		
		//disponibilizar na view
		result.include("categorias",categorias);
		
	}

}
