package manuelbelgrano.jar.dao;

import jakarta.transaction.Transactional;
import manuelbelgrano.jar.model.Persona;


import java.util.List;

@Transactional
public interface PersonaDao {
   List<Persona> obtenerPersonas();

}
