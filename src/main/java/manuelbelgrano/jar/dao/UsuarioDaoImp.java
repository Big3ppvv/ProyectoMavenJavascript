package manuelbelgrano.jar.dao;

import manuelbelgrano.jar.model.Usuario;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Usuario> getUsuarios() {
        String query = "FROM Usuario";
        return entityManager.createQuery(query, Usuario.class).getResultList();
    }

    @Override
    public void registrar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public boolean verificarCredenciales(String email, String password) {
        String query = "FROM Usuario u WHERE u.email = :email AND u.password = :password";
        List<Usuario> lista = entityManager.createQuery(query, Usuario.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultList();
        return !lista.isEmpty();
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        if (usuario != null) {
            entityManager.remove(usuario);
        }
    }
}
