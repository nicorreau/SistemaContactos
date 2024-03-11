package gm.contactos.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import gm.contactos.model.Contacto;
import gm.contactos.service.ContactoService;

@Controller
public class ContactoController {
    private static final Logger logger = LoggerFactory.getLogger(ContactoController.class);

    @Autowired
    ContactoService contactoService;

    @GetMapping("/")
    public String iniciar(ModelMap modelo) {
        List<Contacto> contactos = contactoService.listarContactos();
        contactos.forEach((contacto) -> logger.info(contacto.toString()));
        modelo.put("contactos", contactos);
        return "index"; // index.html
    };

    @GetMapping("/agregar")
    public String Mostraragregar() {
        return "agregar"; // Agregar.html
    }

    @PostMapping("/agregar")
    public String agregar(@ModelAttribute("contactoForma") Contacto contacto) {
        logger.info("Contacto a agregar: " + contacto.toString());
        contactoService.guardarContacto(contacto);
        logger.info("Contacto guardado: " + contacto.toString());
        return "redirect:/"; //Redirigimos al path de inicio
    }

    @GetMapping("/editar/{id}")
    public String mostrarEditar(@PathVariable(value ="id") int idContacto, ModelMap modelo) {
        Contacto contacto = contactoService.buscarContactoPorId(idContacto);
        logger.info ("Contacto a editar (mostrar) : "+ contacto);
        modelo.put("contacto", contacto);
        return "editar"; // Editar.html
    }

    @PostMapping("/editar")
    public String editar(@ModelAttribute("contacto") Contacto contacto) {
        logger.info("Contacto a editar: " + contacto);
        contactoService.guardarContacto(contacto);
        return "redirect:/";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable(value ="id") int idContacto) {
        Contacto contacto = contactoService.buscarContactoPorId(idContacto);
        contactoService.eliminarContacto(contacto);
        logger.info("Contacto eliminado: " + contacto.toString());
        return "redirect:/";
    }

}
