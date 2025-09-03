package manuelbelgrano.jar.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import manuelbelgrano.jar.model.Persona;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class PersonaDaoimp implements PersonaDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Persona> obtenerPersonas() {

        String query  = "From Persona";
        List<Persona> resultado = entityManager.createQuery(query).getResultList();

        return resultado;
    }
}
