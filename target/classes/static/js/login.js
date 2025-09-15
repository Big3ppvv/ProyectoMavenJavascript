async function iniciarSesion() {
  const email = document.querySelector('#txtEmail').value.trim();
  const password = document.querySelector('#txtPassword').value;

  if (!email || !password) {
    alert('Completá email y contraseña.');
    return;
  }

  const resp = await fetch('api/login', {
    method: 'POST',
    headers: { 'Accept': 'application/json', 'Content-Type': 'application/json' },
    body: JSON.stringify({ email, password })
  });

  const texto = await resp.text(); // "OK" o "FAIL"
  if (texto === 'OK') {
    alert('Inicio de sesión correcto.');
    // En esta etapa NO redirige a nada seguro (tokens recién en el capítulo siguiente).
    // window.location.href = '/usuarios.html';
  } else {
    alert('Credenciales incorrectas.');
  }
}
