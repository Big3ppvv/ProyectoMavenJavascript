package manuelbelgrano.jar.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import manuelbelgrano.jar.model.Usuarios;

@Repository
@Transactional
public class UsuarioDaoimp implements UsuarioDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Usuarios> getUsuarios() {

        String query  = "From Usuarios";
        List<Usuarios> resultados = entityManager.createQuery(query).getResultList();

        return resultados;
    }

    @Override
    public void eliminar(Long id){
        Usuarios user = entityManager.find(Usuarios.class,id);
        entityManager.remove(user);
    }
}
