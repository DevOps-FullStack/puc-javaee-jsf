package br.pucminas.aulapratica.jee.trabalho_jee.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.pucminas.aulapratica.jee.trabalho_jee.entity.ClienteEntity;

public class ClienteRepository {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public ClienteEntity salvar(ClienteEntity cliente) {
		em.persist(cliente);
		return cliente;
	}

	public List<ClienteEntity> listar() {
		return em.createQuery("from ClienteEntity", ClienteEntity.class).getResultList();
	}

}
