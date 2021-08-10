package com.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.repositories.EmpreendimentoRepository;
import com.backend.domain.Empreendimento;
import com.backend.dto.EmpreendimentoDTO;

@Service
public class EmpreendimentoService {
	
	@Autowired
	private EmpreendimentoRepository repository;
	
	public List<Empreendimento> findAll() {
		return repository.findAll();
	}
	
	public Empreendimento findById(Long id) throws Exception {
		Optional<Empreendimento> empreendimento = repository.findById(id); //.orElse(null);
		if(empreendimento == null) {
			throw new Exception("Empreendimento não encontrado");
		}
		return empreendimento.get();
	}
	
	public Empreendimento insert(Empreendimento obj) {
		return repository.save(obj);
	}
	
	public Empreendimento update(Empreendimento obj) {
		Empreendimento newObj = repository.findById(obj.getId()).orElse(null);
		updateData(newObj, obj);
		return repository.save(newObj);
	}
	
	private void updateData(Empreendimento newObj, Empreendimento obj) {
		newObj.setNome(obj.getNome());
	}

	public void delete(Long id) throws Exception {
		findById(id);
		repository.deleteById(id);
	}

	public Empreendimento fromDTO(EmpreendimentoDTO objDto) {
		return new Empreendimento(objDto.getId(), objDto.getNome(), objDto.getAtributos(), objDto.getTelefone(), objDto.getCoordenadaX(), objDto.getCoordenadaY());
	}
	
}
