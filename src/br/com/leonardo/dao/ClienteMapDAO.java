package br.com.leonardo.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.leonardo.domain.Cliente;

public class ClienteMapDAO implements IClienteDAO {
	
	private Map<Long, Cliente> map;
	
	public ClienteMapDAO() {
		this.map = new HashMap<>();
	}

	@Override
	public Boolean cadastrar(Cliente cliente) {
		if(this.map.containsKey(cliente.getCpf())) {
			return false;
		}
		this.map.put(cliente.getCpf(),cliente);
		return true;
	}

	@Override
	public void excluir(Long cpf) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente consultar(Long cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
