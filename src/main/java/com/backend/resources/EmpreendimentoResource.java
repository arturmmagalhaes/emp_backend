package com.backend.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.backend.services.EmpreendimentoService;
import com.backend.domain.Empreendimento;
import com.backend.dto.EmpreendimentoDTO;

@RestController
@RequestMapping(value="/empreendimento")
public class EmpreendimentoResource {
	
	@Autowired
	private EmpreendimentoService service;
	
	@CrossOrigin
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Empreendimento>> findAll() {
		List<Empreendimento> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@CrossOrigin
	@RequestMapping(value="/insertemp", method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody EmpreendimentoDTO objDto) {
		Empreendimento obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody EmpreendimentoDTO objDto, @PathVariable String id) {
		
		Empreendimento obj = service.fromDTO(objDto);
		obj.setId(Long.parseLong(id));
		obj = service.update(obj);
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable String id) throws NumberFormatException, Exception{
		service.delete(Long.parseLong(id));
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Empreendimento> findById(@PathVariable Long id) throws Exception {
		Empreendimento obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value="/det/{id}", method=RequestMethod.GET)
	public ResponseEntity<Empreendimento> findEmpreendimento(@PathVariable String id) throws Exception, Exception {
		Empreendimento obj = service.findById(Long.parseLong(id));
		return ResponseEntity.ok().body(obj);
	}
	

}
