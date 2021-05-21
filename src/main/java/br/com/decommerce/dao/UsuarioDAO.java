package br.com.decommerce.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.decommerce.model.Usuario;
import br.com.olimposistema.aipa.dao.DAO;

@RequestScoped
public class UsuarioDAO extends DAO<Usuario> {

	@Inject
	public UsuarioDAO(EntityManager em) {
		super(em, Usuario.class);
		// TODO Auto-generated constructor stub
	}

	@Deprecated
	public UsuarioDAO() {
		super (null,null);
	}

	public Usuario existeUsuarioCom(String email, String senha) {
		
		String jpql = "select u from Usuario as u where u.email = :pEmail and u.senha = :pSenha";
		Query query = em.createQuery(jpql);
		query.setParameter("pEmail", email);
		query.setParameter("pSenha", senha);
		
		Usuario usuario;
		try {
			usuario = (Usuario) query.getSingleResult();
			return usuario;
		} catch (NoResultException e) {
			return null;
		}
		
		
	}
}
