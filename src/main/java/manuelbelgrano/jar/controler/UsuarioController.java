package manuelbelgrano.jar.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import manuelbelgrano.jar.dao.UsuarioDao;
import manuelbelgrano.jar.model.Usuario;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    // Endpoint de prueba
    @RequestMapping(value = "/mensaje")
    public String mensaje() {
        return "hola";
    }

    // Listar usuarios (mock de ejemplo)
    @RequestMapping(value = "/persona")
    public List<String> listarPersonas() {
        return List.of("juan", "martin", "leandro");
    }

    // Usuario de ejemplo hardcodeado
    @RequestMapping(value = "/demo")
    public Usuario listaUsuarios() {
        return new Usuario("juanma", "ruiz", "2615423456", "1234", 12L);
    }

    // Obtener todos los usuarios (desde la DB)
    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioDao.getUsuarios();
    }

    // Registrar usuario
    @PostMapping
    public void registrar(@RequestBody Usuario usuario) {
        usuarioDao.registrar(usuario);
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioDao.eliminar(id);
    }
}
