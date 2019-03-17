package com.weliton.cursomc.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.weliton.cursomc.dto.CategoriaDTOO;
import com.weliton.cursomc.services.CategoriaService;
import com.weliton.cursomc.wrapper.CategoriaWrapper;

@Component
public class CategoriaBusiness {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private CategoriaWrapper wrapper;

	/**
	 * Metado que converte todos objetos encontrado
	 *  no banco categoria para DTO
	 * @return
	 */
	public List<CategoriaDTOO> buscarTodosDTO(){
		return wrapper.wrapperTodos(categoriaService.BuscarTodos());
	}
	
}
