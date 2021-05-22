package br.com.decommerce.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.com.decommerce.dao.ProdutoDAO;
import br.com.decommerce.interceptors.SomenteLogado;
import br.com.decommerce.model.Categoria;
import br.com.decommerce.model.Produto;
import br.com.olimposistema.aipa.dao.DAO;

@Controller
@Path("formproduto")
public class FormProdutoController {
	@Inject Validator validator;
	@Inject Result result;
	@Inject DAO<Categoria> categoriaDAO;
	@Inject ProdutoDAO produtoDAO;
	
	
	@Get("")
	@SomenteLogado
	public void formproduto() {
		result.include("categorias",categoriaDAO.selectAll());
	}
	
	@IncludeParameters
	@SomenteLogado
	@Post("salvaProduto")
	public void salvaProduto(@Valid Produto produto) {
		validator.onErrorRedirectTo(this).formproduto();
		produtoDAO.insertOrUpdate(produto);
		
		result.redirectTo(ProdutosController.class).produtos(null);

	}
	
}
