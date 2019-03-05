package com.weliton.cursomc.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.weliton.cursomc.domain.Categoria;
import com.weliton.cursomc.dto.CategoriaDTO;
import com.weliton.cursomc.dto.CategoriaDTOO;
import com.weliton.cursomc.services.CategoriaService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResources {
	@Autowired
	private CategoriaService service;
	
	// padrao Rest de pesquisar dados
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Categoria> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Categoria obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);

	}
	//padrao Rest de inserir dados
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//padrao Rest de atualizar dados
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) throws ObjectNotFoundException{
	obj.setId(id);
	obj = service.update(obj);	
	return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) throws ObjectNotFoundException {
		service.delete(id);
		return ResponseEntity.noContent().build();
	
}
//	//padrao Rest de pesquisar dados
//	@RequestMapping(method=RequestMethod.GET)
//	public ResponseEntity<List<CategoriaDTO>> findAll() throws ObjectNotFoundException {
//		List<Categoria> list = service.findAll();
//		List<CategoriaDTO> listDto = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
//		return ResponseEntity.ok().body(listDto);
//
//	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTOO>> findTodos() throws ObjectNotFoundException {
		return ResponseEntity.ok(this.service.buscarTodosDTO());

	}
	
	
}
