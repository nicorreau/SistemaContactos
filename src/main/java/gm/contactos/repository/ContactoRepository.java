package gm.contactos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gm.contactos.model.Contacto;

@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer> {

}
    

