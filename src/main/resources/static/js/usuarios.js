$(document).ready(function () {
  CargarUsuarios();

  async function CargarUsuarios() {
    const request = await fetch('api/usuario', {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
    });
    const usuarios = await request.json();

    let listadoHtml = '';
    for (let usuario of usuarios) {
        let botonEliminar = '<a href="#" onclick="eliminarUsuario('+usuario.id +')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';
        let usuarioHtml = '<tr><td>' + usuario.id + '</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>' + usuario.telefono + '</td><td>' + botonEliminar + '</td></tr>';
        listadoHtml += usuarioHtml;
    }

    document.querySelector('#usuarios tbody').innerHTML = listadoHtml;

    // Destruir DataTable existente antes de reinicializar
    if ($.fn.DataTable.isDataTable('#usuarios')) {
        $('#usuarios').DataTable().destroy();
    }

    $('#usuarios').DataTable();
  }
});

// Función global para eliminar usuario
async function eliminarUsuario(id) {
    if(!confirm('¿Desea eliminar usuario?')){
        return;
    }
     const request = await fetch('api/usuario/' + id, {
          method: 'DELETE',
          headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
          },
     });
    location.reload();
}