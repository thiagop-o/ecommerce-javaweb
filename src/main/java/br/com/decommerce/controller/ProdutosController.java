package br.com.decommerce.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.decommerce.dao.ProdutoDAO;
import br.com.decommerce.model.Categoria;
import br.com.decommerce.model.Produto;
import br.com.olimposistema.aipa.dao.DAO;

@Controller
@Path("produtos")
public class ProdutosController {
	@Inject Result result;
	@Inject ProdutoDAO produtoDAO;
	@Inject DAO<Categoria> categoriaDAO;
	
	@IncludeParameters
	@Get("")
	public void produtos(Produto filtro) {
		result.include("categorias",categoriaDAO.selectAll());
		
		
		
//		if(filtro.getId() == 0 && filtro == null) {
//			result.include("produtos",produtoDAO.buscaTodosOsProdutosOrdenadoPeloNome());
//		}else {
//			result.include("produtos",produtoDAO.filter(filtro));
//		}
		
		
		
		
		if(filtro != null) {
			result.include("produtos",produtoDAO.filter(filtro));
		}else {
			result.include("produtos",produtoDAO.selectAll());
		}
		
	}
}
