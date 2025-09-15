document.addEventListener('DOMContentLoaded', () => {
  // Si usaste localStorage para otras páginas, refrescar/limpiar puede ayudar
  // localStorage.clear();
});

async function registrarUsuario() {
  const nombre   = document.querySelector('#txtNombre').value.trim();
  const apellido = document.querySelector('#txtApellido').value.trim();
  const email    = document.querySelector('#txtEmail').value.trim();
  const pass1    = document.querySelector('#txtPassword').value;
  const pass2    = document.querySelector('#txtRepetirPassword').value;

  if (!nombre || !apellido || !email || !pass1 || !pass2) {
    alert('Completá todos los campos.');
    return;
  }

  if (pass1 !== pass2) {
    alert('Las contraseñas no coinciden.');
    return;
  }

  const usuario = {
    nombre,
    apellido,
    email,
    telefono: null, // el form no lo pide; lo dejamos null según guía
    password: pass1
  };

  const resp = await fetch('api/usuario',{
    method: 'POST',
    headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' },
    body: JSON.stringify(usuario)
  });

  if (resp.ok) {
    alert('Usuario registrado correctamente.');
    // si querés, redirigí a login:
    // window.location.href = '/login.html';
  } else {
    alert('No se pudo registrar el usuario.');
  }
}
