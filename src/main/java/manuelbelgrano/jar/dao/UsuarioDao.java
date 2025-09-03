package manuelbelgrano.jar.dao;

import java.util.List;

import jakarta.transaction.Transactional;
import manuelbelgrano.jar.model.Usuarios;

@Transactional
public interface UsuarioDao {
    
    List<Usuarios> getUsuarios();
    void eliminar(Long id);
}
