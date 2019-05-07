package br.pucminas.aulapratica.jee.trabalho_jee.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.pucminas.aulapratica.jee.trabalho_jee.entity.ClienteEntity;
import br.pucminas.aulapratica.jee.trabalho_jee.repository.ClienteRepository;
import br.pucminas.aulapratica.jee.trabalho_jee.resource.ClienteResource;

@Stateless
public class ClienteBusiness {

	@Inject
	private ClienteRepository clienteRepository;

	public void salvarCliente(ClienteResource clienteResource) {
		/* Implementação da lógica de salvar um cliente */

		clienteRepository.salvar(toEntity(clienteResource));
	}

	/* Implementação da listagem de clientes conforme desafio 2 */
	public List<ClienteResource> listarClientes() {
		List<ClienteEntity> entities = clienteRepository.listar();
		List<ClienteResource> clienteResources = new ArrayList<>();

		for (ClienteEntity clienteEntity : entities) {
			clienteResources.add(toResource(clienteEntity));
		}

		return clienteResources;
	}

	private ClienteResource toResource(ClienteEntity clienteEntity) {
		ClienteResource clienteResource = new ClienteResource();

		clienteResource.setId(clienteEntity.getId());
		clienteResource.setNome(clienteEntity.getNome());
		clienteResource.setEmail(clienteEntity.getEmail());
		clienteResource.setDataNascimento(clienteEntity.getDataNascimento());

		return clienteResource;
	}

	private ClienteEntity toEntity(ClienteResource clienteResource) {
		ClienteEntity clienteEntity = new ClienteEntity();

		clienteEntity.setId(clienteResource.getId());
		clienteEntity.setNome(clienteResource.getNome());
		clienteEntity.setEmail(clienteResource.getEmail());
		clienteEntity.setDataNascimento(clienteResource.getDataNascimento());

		return clienteEntity;
	}
}
