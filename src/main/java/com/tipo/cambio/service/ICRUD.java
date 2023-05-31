package com.tipo.cambio.service;

import java.util.List;

public interface ICRUD<T, ID> {

	T registrar(T t) throws Exception;

	T modificar(T t) throws Exception;

	List<T> listar() throws Exception;
	
	
}

