$(document).ready(function () {

  CargarUsuarios();
  $('#usuarios').DataTable();

  async function CargarUsuarios() {
    const request = await fetch('api/usuario', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'content-Type': 'application/json'
      },
    });
    const usuarios = await request.json();



    let listadoHtml = '';
    for (let usuario of usuarios) {

        let botonEliminar = '<a href="#" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';


        let usuarioHtml = '<tr><td>' + usuario.id + '</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>' + usuario.telefono + '</td><td>' + botonEliminar + '</td></tr>';

        listadoHtml += usuarioHtml;
    }


    document.querySelector('#usuarios tbody').innerHTML = listadoHtml;


  }



}
)

