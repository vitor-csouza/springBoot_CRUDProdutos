package br.com.fiap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.model.MarcaModel;
import br.com.fiap.repository.MarcaRepository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/marca")
public class MarcaController {
	
	private static final String MARCA_FOLDER="marca/";
	
	@Autowired
	public MarcaRepository marcaRepository;
	
	
	//get
	
	@GetMapping()
	public String getAll(Model model) {
		model.addAttribute("marcas",marcaRepository.getAllMarcas());
		return MARCA_FOLDER + "marcas";
	}
	
	// get by Id
	
	@GetMapping("/{id}")
	public String getById(@PathVariable("id") long id, Model model) {
		model.addAttribute("marca",marcaRepository.getById(id));
		return MARCA_FOLDER + "marca-detalhe";
	}
	
	//create
	@PostMapping()
	public String create(@Valid MarcaModel marca, BindingResult bindingResult,RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()) {
			return MARCA_FOLDER + "marca-novo";
		}
		
		marcaRepository.create(marca);
		redirectAttributes.addFlashAttribute("message","Marca cadastrada com sucesso");
		return "redirect:/marca";
	}
	
	//update
	@PutMapping("/{id}")
	public String update(@PathVariable("id") long id, Model model, @Valid MarcaModel marca,BindingResult bindingResult,RedirectAttributes redirectAttributes) {
		
		marca.setId(id);
		marcaRepository.create(marca);
		redirectAttributes.addFlashAttribute("messages","Marca atualizado com sucesso!");
		model.addAttribute("marcas", marcaRepository.getAllMarcas());
		return "redirect:/marca";
	}
	
	//delete
	@DeleteMapping("/{id}")
	public String delete(@PathVariable("id") long id, Model model,RedirectAttributes redirectAttributes) {
		marcaRepository.deleteById(id);
		redirectAttributes.addFlashAttribute("messages","Marca excluída com sucesso!");
		model.addAttribute("marcas",marcaRepository.getAllMarcas());
		return "redirect:/marca";
	}
	
	
}
