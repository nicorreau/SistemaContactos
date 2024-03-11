package gm.contactos.service;

import java.util.List;

import gm.contactos.model.Contacto;

public interface IContactoService {
    
    public List<Contacto> listarContactos();
    
    public Contacto buscarContactoPorId(Integer idContacto);

    public void guardarContacto(Contacto contacto);

    public void eliminarContacto(Contacto contacto);
    
}
