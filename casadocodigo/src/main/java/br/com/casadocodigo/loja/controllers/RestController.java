package br.com.casadocodigo.loja.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.daos.InterfaceDAO;
import br.com.casadocodigo.loja.models.Product;

@RequestMapping("/api/products")
@Controller
public class RestController {
	
	@Autowired InterfaceDAO interfaceDAO;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<Product> list(){
		return interfaceDAO.findAll();
	}
}
