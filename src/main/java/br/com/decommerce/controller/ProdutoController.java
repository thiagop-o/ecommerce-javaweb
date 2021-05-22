package br.com.decommerce.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.decommerce.dao.ProdutoDAO;
import br.com.decommerce.model.Produto;

@Controller
@Path("produto")
public class ProdutoController {
	
	@Inject ProdutoDAO produtoDAO;
	@Inject Result result;
	
	@Get("")
	public void listagemDeProdutos() {
		List<Produto> produtos = produtoDAO.selectAll();
		result.use(Results.json())
		.withoutRoot()
		.from(produtos)
		.include("imagem")
		.serialize();
	}
}
