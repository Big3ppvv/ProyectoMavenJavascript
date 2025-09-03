package manuelbelgrano.jar.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import manuelbelgrano.jar.dao.UsuarioDao;
import manuelbelgrano.jar.model.Usuarios;

@RestController
public class usuariocontroler {
    @Autowired
    private UsuarioDao usuarioDao;

        @RequestMapping (value = "/mensaje")
    public String mensaje() {
        return "hola";
    }
    
    @RequestMapping (value = "/persona")
    public List<String> ListarPersonas(){
        return List.of("juan","martin","leandro");
    }

    @RequestMapping (value = "/usuario")
    public Usuarios ListaUsuarios(){
        Usuarios usuarios = new Usuarios(" juanma " ,"ruiz ","2615423456", "1234",12);

        return usuarios;
    }

    @RequestMapping(value ="api/usuario")
    public List<Usuarios> getUsuarios(){
        List<Usuarios> user = usuarioDao.getUsuarios();
        return  user;
    }

    @RequestMapping(value ="api/usuario/{id}" ,method= RequestMethod.DELETE)
    public void eliminar(@PathVariable Long id){
            usuarioDao.eliminar(id);
    }


}
