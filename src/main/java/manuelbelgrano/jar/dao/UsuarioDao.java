package manuelbelgrano.jar.dao;

import manuelbelgrano.jar.model.Usuario;
import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();
    void registrar(Usuario usuario);
    boolean verificarCredenciales(String email, String password);
    void eliminar(Long id);
}

