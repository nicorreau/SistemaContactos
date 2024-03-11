package gm.contactos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gm.contactos.model.Contacto;
import gm.contactos.repository.ContactoRepository;

@Service
public class ContactoService implements IContactoService {
    
    @Autowired
    private ContactoRepository contactoRepository;

    @Override
    public List<Contacto> listarContactos() {
        return contactoRepository.findAll();        
    }

    @Override
    public Contacto buscarContactoPorId(Integer idContacto) {
        return contactoRepository.findById(idContacto).orElse(null);
    }
    
    @Override
    public void guardarContacto(Contacto contacto) {
        contactoRepository.save(contacto);
    }
    
    @Override
    public void eliminarContacto(Contacto contacto) {
        contactoRepository.delete(contacto);
        
    }
    
}
