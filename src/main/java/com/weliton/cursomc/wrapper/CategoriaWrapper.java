package com.weliton.cursomc.wrapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.weliton.cursomc.domain.Categoria;
import com.weliton.cursomc.dto.CategoriaDTOO;

@Component
public class CategoriaWrapper {
	
/**
 * Metado que converte Categoria para categoriaDTO, com java8
 * @param categorias
 * @return
 */
	public List<CategoriaDTOO> wrapTodos(List<Categoria> categorias){
		
		List<CategoriaDTOO> categoriaDTO = new ArrayList<CategoriaDTOO>();
		
		categorias.forEach( categoria -> categoriaDTO.add(
				new CategoriaDTOO(
						categoria.getId(),
						categoria.getNome())));
		return categoriaDTO;
	}
	
	/**
	 * Metado que converte Categoria para categoriaDTO, com for normal
	 * @param param
	 * @return
	 */
	public List<CategoriaDTOO> wrapperTodos(List<Categoria> param){
		List<CategoriaDTOO> dto = new ArrayList<CategoriaDTOO>();
		
		for(Categoria categoria : param) {
		CategoriaDTOO categoriaDTO = new CategoriaDTOO();
			
			categoriaDTO.setId(categoria.getId());
			categoriaDTO.setNome(categoria.getNome());
			dto.add(categoriaDTO);
		}
		
		return dto;
	}
	
	

}
