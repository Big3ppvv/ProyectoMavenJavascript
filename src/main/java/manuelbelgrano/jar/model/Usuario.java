package manuelbelgrano.jar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String password;

    // Constructor vacío (obligatorio para JPA)
    public Usuario() {}

    // Constructor con parámetros
    public Usuario(String nombre, String apellido, String telefono, String password, Long id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.password = password;
        this.id = id;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
