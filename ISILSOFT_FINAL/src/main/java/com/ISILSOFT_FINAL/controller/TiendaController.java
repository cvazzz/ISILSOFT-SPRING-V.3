package com.ISILSOFT_FINAL.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ISILSOFT_FINAL.entity.JefeTienda;
import com.ISILSOFT_FINAL.entity.Tienda;
import com.ISILSOFT_FINAL.repository.JefeRepository;
import com.ISILSOFT_FINAL.repository.TiendaRepository;
@Controller
@RequestMapping("/Tienda")
public class TiendaController {
	@Autowired
	TiendaRepository tiendaRepository;
	@Autowired
	JefeRepository jefeRepository;
	@RequestMapping(value="/buscarxdistri", method=RequestMethod.GET)
	public String buscarxdistri(HttpServletRequest request,@RequestParam("distrito")String distrito,Model model) {
		List<Tienda>listTienda=tiendaRepository.findByDistrito(distrito);
		model.addAttribute("listTienda",listTienda);
		return "gestionTiendas";
	}
	 @PostMapping(value="crearTienda")
	public String crearTienda(HttpServletRequest request,@ModelAttribute("objTienda")Tienda objTienda,Model model ) {
		tiendaRepository.save(objTienda);
		List<Tienda>listTienda=tiendaRepository.findAll();
		model.addAttribute("listTienda",listTienda);
		return "gestionTiendas";	
	}
	
	@PostMapping(value="/nuevaTienda")
	public String nuevaTienda(HttpServletRequest request, Model model) {
		Tienda objTienda = new Tienda(); 
		model.addAttribute("objTienda",objTienda);
		
		List<JefeTienda>listaJefe=jefeRepository.findAll();
		model.addAttribute("listaJefe",listaJefe);
		return "nuevaTienda";
	}

	
	

}
