package com.tipo.cambio.service.impl;

import java.util.List;

import com.tipo.cambio.repo.IGenericRepo;
import com.tipo.cambio.service.ICRUD;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

	protected abstract IGenericRepo<T, ID> getRepo();
	
	@Override
	public T registrar(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public T modificar(T t) throws Exception {
		return getRepo().save(t);
	}

	@Override
	public List<T> listar() throws Exception {		
		return getRepo().findAll();
	}

}
