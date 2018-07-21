package com.weliton.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.weliton.cursomc.domain.Categoria;
import com.weliton.cursomc.repositories.CategoriaRepository;
import com.weliton.cursomc.services.exception.DataIntegrityException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
	
	
	public Categoria buscar(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
		}
	
		public Categoria insert(Categoria obj) {
			obj.setId(null);
			return repo.save(obj);
		}
		
		public Categoria update(Categoria obj) throws ObjectNotFoundException {
			buscar(obj.getId());
			return repo.save(obj);
		}
		
		public void delete(Integer id) throws ObjectNotFoundException {
			//verefica se o id existe na linha a baixo
			buscar(id);
			
			try {
			repo.deleteById(id);
			}
			catch(DataIntegrityViolationException e) {
				throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
			}
		}
		
		public List<Categoria> findAll(){
			return repo.findAll();
		}
		
}
