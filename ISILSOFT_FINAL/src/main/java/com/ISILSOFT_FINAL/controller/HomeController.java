package com.ISILSOFT_FINAL.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ISILSOFT_FINAL.entity.Tienda;
import com.ISILSOFT_FINAL.entity.Usuario;
import com.ISILSOFT_FINAL.repository.TiendaRepository;
import com.ISILSOFT_FINAL.repository.UsuarioRepository;


@Controller
@RequestMapping("/home") /*nombre al controlador*/
public class HomeController {
	
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	TiendaRepository tiendaRepository;
	@RequestMapping(value="/validarUsuario",method=RequestMethod.POST)
	public String validarUsuario(HttpServletRequest request, @RequestParam("correo")String correo,@RequestParam("password")String password){
		String pagina;
		Usuario objusuario=usuarioRepository.findByCorreoAndPassword(correo, password);
		if(objusuario!=null) {
			pagina="principal";
		}else {
			pagina="index";
		}
		return pagina;
	}

	@RequestMapping(value="/validarCorreo", method=RequestMethod.POST)
	public String validarCorreo(
	        HttpServletRequest request,
	        @RequestParam("correo") String correo,
	        @RequestParam("newContrasenha") String newContrasenha,
	        @RequestParam("confContrasenha") String confContrasenha,
	        Model model) {
	    
	    String pagina;
	    Usuario objUsuarioEmail = usuarioRepository.findBycorreo(correo);

	    if (objUsuarioEmail != null) {
	        if (newContrasenha.isEmpty() || confContrasenha.isEmpty()) {
	            String mensaje = "Las contraseñas no pueden estar vacías";
	            model.addAttribute("mensaje", mensaje);
	            pagina = "recuperarContra";
	        } else {
	            if (newContrasenha.equals(confContrasenha)) {
	                // Actualizar la contraseña del usuario con el valor de newContrasenha
	                objUsuarioEmail.setPassword(newContrasenha);
	                // Guardar el usuario actualizado en la base de datos
	                usuarioRepository.save(objUsuarioEmail);
	                pagina = "index";
	            } else {
	                String mensaje = "Las contraseñas no coinciden";
	                model.addAttribute("mensaje", mensaje);
	                pagina = "recuperarContra";
	            }
	        }
	    } else {
	        String mensaje = "No existe un usuario con ese correo";
	        model.addAttribute("mensaje", mensaje);
	        pagina = "recuperarContra";
	    }
	    return pagina;
	}
	@GetMapping(value="/gestionarTienda") //llamada simple
	public String gestionarTienda(HttpServletRequest request,Model model) {
		List<Tienda>listTienda=tiendaRepository.findAll();
		model.addAttribute("listTienda",listTienda);
		return "gestionTiendas";
	}
	@GetMapping(value="/recuperarContrasenha") //llamada simple
	public String recuperarContrasenha(HttpServletRequest request) {
		return "recuperarContra";
	}
	
	
	
	
	

}
