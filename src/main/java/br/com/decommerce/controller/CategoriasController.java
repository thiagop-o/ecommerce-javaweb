package br.com.decommerce.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.decommerce.interceptors.SomenteLogado;

@Controller
@Path("categorias")
public class CategoriasController {
	@Inject HttpSession session;	
	@Inject Result result;
	
	@Get("")
	@SomenteLogado
	public void categorias() {
		

		
	}

}
