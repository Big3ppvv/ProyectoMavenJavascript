package manuelbelgrano.jar.controler;

import manuelbelgrano.jar.dao.PersonaDao;
import manuelbelgrano.jar.model.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonaController {

    @Autowired
    private PersonaDao personaDao;

    @RequestMapping(value = "api/persona")
    public List<Persona> getPersona(){
        List<Persona> user = personaDao.obtenerPersonas();
        return  user;
    }

}
