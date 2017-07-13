package br.com.caelum.fj27.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.caelum.fj27.daos.InterfaceDAO;
import br.com.caelum.fj27.daos.ProductDAO;
import br.com.caelum.fj27.infra.FileSaver;
import br.com.caelum.fj27.models.BookType;
import br.com.caelum.fj27.models.Product;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private InterfaceDAO interfaceDAO;
	
//	@Autowired
//	private FileSaver fileSaver;
	
	@RequestMapping("/form")
	public ModelAndView form(Product product){
		ModelAndView modelAndView = new ModelAndView("products/form");
		modelAndView.addObject("types", BookType.values());
		
		return modelAndView;
	}
	
	@CacheEvict(value="lastProducts", allEntries=true)
	@Transactional
	@PostMapping
	public ModelAndView save(MultipartFile summary,@Valid Product product, BindingResult bindingResult, RedirectAttributes redirectAttributes){
		if(bindingResult.hasErrors()){
			return form(product);
		}
		
//		String webPath = fileSaver.write("uploaded-summaries", summary);
//		product.setSummaryPath(webPath);
		productDAO.save(product);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso");
		
		return new ModelAndView("redirect:products");
	}
	
	//@Autowired
	@Cacheable("lastProducts")
	@GetMapping
	public ModelAndView list(){
		ModelAndView modelAndView = new ModelAndView("products/list");
		modelAndView.addObject("products", interfaceDAO.findAll());
	
		return modelAndView;
	}
	
	@GetMapping(value="/{id}")
	public ModelAndView show(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView("products/show");
		modelAndView.addObject("product", interfaceDAO.findOne(id));
		return modelAndView;
	}
}
