package br.com.casadocodigo.loja.controllers;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.loja.daos.InterfaceDAO;
import br.com.casadocodigo.loja.models.Product;


@RestController
public class RestControllerAppl {
	
	@Autowired 
	InterfaceDAO interfaceDAO;
	
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Product> list(){
		return interfaceDAO.findAll();
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public Product show(@PathVariable Integer id){
		return interfaceDAO.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Product> save(@RequestBody Product p){
		p.setId(101);
		URI uri = URI.create("/api/products/"+p.getId());
		System.out.println(p);
		
		return ResponseEntity.created(uri).body(p);
	}
}
