package manuelbelgrano.jar.controler;

import manuelbelgrano.jar.dao.UsuarioDao;
import manuelbelgrano.jar.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class AuthController {

    @Autowired
    private UsuarioDao usuarioDao;

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {
        boolean valido = usuarioDao.verificarCredenciales(usuario.getEmail(), usuario.getPassword());
        return valido ? "OK" : "FAIL";
    }
}

